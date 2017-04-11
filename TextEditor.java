  package com.tpoint;

public class TextEditor {
	   private SpellChecker spellChecker;
	   
	   public TextEditor(SpellChecker spellChecker) {
		   this.spellChecker = spellChecker;
		   spellChecker.checkSpelling();
	   }
	   
}
