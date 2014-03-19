package modeRator.tool;
import processing.app.*;

/*
 * This class does all the changes to the script
 * it goes through the tabs and performs replacements
 */

public class Replacer {
	Editor editor;

	public Replacer(Editor _editor) {
		this.editor = _editor;
	}

	public void update() {
		Sketch sketch = editor.getSketch();
		int tabsN = sketch.getCodeCount();	//how many tabs there is?
		
		String modeName = editor.getMode().getTitle();
		//we check, whether the mode is known.
		if( modeName.equals("Java") || modeName.equals("JavaScript") || modeName.equals("Android") ) {
			System.out.println("Recognized mode: "+modeName);
		}
		else {
			System.out.println("Mode not recognized... No changes can be done!");
			modeName = "unknown";
		}

		//for every tab...
		for (int tab = 0; tab < tabsN; tab++) {
			String newText = "";
			int linesN = editor.getLineCount();
			System.out.println("lines: " + linesN);
			
			//for every line in the tab...
			for (int i = 0; i < linesN; i++) {
				String line = editor.getLineText(i);
				
				if (modeName.equals("Java")) {
					if (line.equals("/*[Java]")) {
						line = "/*[Java]*/";
					} else if (line.equals("/*[JavaScript]*/")) {
						line = "/*[JavaScript]";
					} else if (line.equals("/*[Android]*/")) {
						line = "/*[Android]";
					}
				}

				if (modeName.equals("JavaScript")) {
					if (line.equals("/*[Java]*/")) {
						line = "/*[Java]";
					} else if (line.equals("/*[JavaScript]")) {
						line = "/*[JavaScript]*/";
					} else if (line.equals("/*[Android]*/")) {
						line = "/*[Android]";
					}
				}

				if (modeName.equals("Android")) {
					if (line.equals("/*[Java]*/")) {
						line = "/*[Java]";
					} else if (line.equals("/*[JavaScript]*/")) {
						line = "/*[JavaScript]";
					} else if (line.equals("/*[Android]")) {
						line = "/*[Android]*/";
					}
				}

				newText += line;

				if (i < linesN-1) {
					newText += "\n";
				}
			}

			editor.setText(newText);
			sketch.handleNextCode();
		}
		if(!modeName.equals("unknown")) {
			editor.getSketch().setModified(true);
		}
	}
}
