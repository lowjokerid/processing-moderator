/**
 * ModeRator - a parser for mixed JS/Java/Android code.
 *
 * ##copyright##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author		##author##
 * @modified	##date##
 * @version		##version##
 */

 package template.tool;
 
 import processing.app.*;
 import processing.app.tools.*;
 import modeRator.tool.Replacer;
 
 
 public class ModeRator implements Tool {
 
	Editor editor;
	Replacer rp;
	boolean isRunning = false;
 
	public String getMenuTitle() {
		return "ModeRator parser";
	}
 
	public void init(Editor editor) {
		this.editor = editor;
		this.rp     = new Replacer(editor);
	}
 
	public void run() {
		if(!isRunning) { 
			System.out.println( "ModeRator parser for JS/Java/Android mixed code" );
			isRunning = true;
			rp.update();
		} else {
			rp.update();
		}
	}
 
 }



