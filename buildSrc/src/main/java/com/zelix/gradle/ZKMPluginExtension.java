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

import java.util.Properties;

public class ZKMPluginExtension {
   private String scriptName; //Path to the ZKM Script file to execute
   private String logFileName = "ZKM_log.txt"; 
   private String trimLogFileName = "ZKM_TrimLog.txt"; 
   private String defaultExcludeFileName = "defaultExclude.txt"; 
   private String defaultTrimExcludeFileName = "defaultTrimExclude.txt";
   private String defaultDirectoryName; 
   private boolean isVerbose = true; 
   private boolean isParseOnly = false; 
   private Properties extraProperties = new Properties();

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public String getTrimLogFileName() {
        return trimLogFileName;
    }

    public void setTrimLogFileName(String trimLogFileName) {
        this.trimLogFileName = trimLogFileName;
    }

    public String getDefaultExcludeFileName() {
        return defaultExcludeFileName;
    }

    public void setDefaultExcludeFileName(String defaultExcludeFileName) {
        this.defaultExcludeFileName = defaultExcludeFileName;
    }

    public String getDefaultTrimExcludeFileName() {
        return defaultTrimExcludeFileName;
    }

    public void setDefaultTrimExcludeFileName(String defaultTrimExcludeFileName) {
        this.defaultTrimExcludeFileName = defaultTrimExcludeFileName;
    }

    public String getDefaultDirectoryName() {
        return defaultDirectoryName;
    }

    public void setDefaultDirectoryName(String defaultDirectoryName) {
        this.defaultDirectoryName = defaultDirectoryName;
    }

    public boolean isVerbose() {
        return isVerbose;
    }

    public void setIsVerbose(boolean isVerbose) {
        this.isVerbose = isVerbose;
    }

    public boolean isParseOnly() {
        return isParseOnly;
    }

    public void setIsParseOnly(boolean isParseOnly) {
        this.isParseOnly = isParseOnly;
    }

    public Properties getExtraProperties() {
        return extraProperties;
    }

    public void setExtraProperties(Properties extraProperties) {
        this.extraProperties = extraProperties;
    }
}