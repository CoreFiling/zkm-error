/*-----------------------------------------------------------------------------*
 * Copyright 2019 Zelix Pty Ltd (ACN 078 740 093). All  Rights Reserved.       *
 *                                                                             *
 * Licensed under the GNU General Public License, version 3                    *
 * http://www.gnu.org/licenses/gpl-3.0.txt                                     *
 * The license includes the following conditions.                              *
 *                                                                             *
 *  THERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY           *
 * APPLICABLE LAW.  EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT      *
 * HOLDERS AND/OR OTHER PARTIES PROVIDE THE PROGRAM "AS IS" WITHOUT WARRANTY   *
 * OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO,    *
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR      *
 * PURPOSE.  THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM  *
 * IS WITH YOU.  SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF    *
 * ALL NECESSARY SERVICING, REPAIR OR CORRECTION.                              *
 *                                                                             *
 * IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING       *
 * WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MODIFIES AND/OR CONVEYS   *
 * THE PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY *
 * GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE    *
 * USE OR INABILITY TO USE THE PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF   *
 * DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD  *
 * PARTIES OR A FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS),    *
 * EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF   *
 * SUCH DAMAGES.                                                               *
 *                                                                             *
 *-----------------------------------------------------------------------------*/
package com.zelix.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Map;
import java.util.Properties;

public class ZKMPluginTask extends DefaultTask {

  @TaskAction
  public void run() {
    ZKMPluginExtension extension = getProject().getExtensions().findByType(ZKMPluginExtension.class);
    if (extension == null) {
      extension = new ZKMPluginExtension();
    }

    final String scriptName = extension.getScriptName();
    if (scriptName == null) {
      throw new GradleException("No ZKM Script file specified. Null scriptName.");
    }
    final File scriptFile = new File(scriptName);
    if (!scriptFile.exists() || scriptFile.isDirectory()) {
      throw new GradleException("Specified ZKM Script '" + scriptFile.getAbsolutePath() + "' does not exist or is a directory");
    }
    final String logFileName = extension.getLogFileName();
    final String trimLogFileName = extension.getTrimLogFileName();
    final String defaultExcludeFileName = extension.getDefaultExcludeFileName();
    final String defaultTrimExcludeFileName = extension.getDefaultTrimExcludeFileName();
    final String defaultDirectoryName = extension.getDefaultDirectoryName();
    final boolean isVerbose = extension.isVerbose();
    final boolean isParseOnly = extension.isParseOnly();
    Properties extraProperties = extension.getExtraProperties();
    if (extraProperties == null) {
      extraProperties = new Properties();
    }
    if (scriptFile != null) {
      extraProperties.put("scriptFile", scriptFile.getAbsolutePath());
    }
    if (logFileName != null) {
      extraProperties.put("logFileName", (new File(logFileName)).getAbsolutePath());
    }
    if (trimLogFileName != null) {
      extraProperties.put("trimLogFileName", (new File(trimLogFileName)).getAbsolutePath());
    }
    if (defaultExcludeFileName != null) {
      extraProperties.put("defaultExcludeFileName", (new File(defaultExcludeFileName)).getAbsolutePath());
    }
    if (defaultTrimExcludeFileName != null) {
      extraProperties.put("defaultTrimExcludeFileName", (new File(defaultTrimExcludeFileName)).getAbsolutePath());
    }
    if (defaultDirectoryName != null) {
      extraProperties.put("defaultDirectoryName", (new File(defaultDirectoryName)).getAbsolutePath());
    }
    extraProperties.put("isVerbose", isVerbose);
    extraProperties.put("isParseOnly", isParseOnly);
    final Project project = getProject();
    for (final Map.Entry entry : project.getProperties().entrySet()) {
      if (entry.getKey() instanceof String && entry.getValue() instanceof String) {
        extraProperties.put(entry.getKey(), entry.getValue());
      }
    }
    try {
      com.zelix.ZKM.run(scriptFile.getAbsolutePath(), logFileName, trimLogFileName, defaultExcludeFileName, defaultTrimExcludeFileName,
          defaultDirectoryName, isVerbose, isParseOnly, extraProperties);

    }
    catch (final Exception ex) {
      ex.printStackTrace();
      throw new GradleException(ex.toString(), ex);
    }
  }
}
