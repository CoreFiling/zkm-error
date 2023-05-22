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

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ZKMPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("zkmSetting", ZKMPluginExtension.class);
        project.getTasks().create("zkmTask", ZKMPluginTask.class);
    }
}
