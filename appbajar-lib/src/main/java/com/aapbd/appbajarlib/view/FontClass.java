package com.aapbd.appbajarlib.view;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;

public class FontClass {

	
	
	/*
	 * This is nice first word cap
	 * The input string, e.g. "Small Caps"
	 * A formatted SpannableString, e.g. "Sᴍᴀʟʟ Cᴀᴘs"
	 * 
	 * */


    public static SpannableString getSmallCapsString(String input) {
        // values needed to record start/end points of blocks of lowercase letters

        input = input.toLowerCase();

        final StringBuilder result = new StringBuilder(input.length());
        String[] words = input.split("\\s");
        for (int i = 0, l = words.length; i < l; ++i) {
            if (i > 0) result.append(" ");
            result.append(Character.toUpperCase(words[i].charAt(0)))
                    .append(words[i].substring(1));

        }

        input = result.toString();

        char[] chars = input.toCharArray();
        int currentBlock = 0;
        int[] blockStarts = new int[chars.length];
        int[] blockEnds = new int[chars.length];
        boolean blockOpen = false;

        // record where blocks of lowercase letters start/end
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                if (!blockOpen) {
                    blockOpen = true;
                    blockStarts[currentBlock] = i;
                }
                // replace with uppercase letters
                chars[i] = (char) (c - 'a' + '\u0041');
            } else {
                if (blockOpen) {
                    blockOpen = false;
                    blockEnds[currentBlock] = i;
                    ++currentBlock;
                }
            }
        }

        // add the string end, in case the last character is a lowercase letter
        blockEnds[currentBlock] = chars.length;

        // shrink the blocks found above
        SpannableString output = new SpannableString(String.valueOf(chars));
        for (int i = 0; i < Math.min(blockStarts.length, blockEnds.length); ++i) {
            output.setSpan(new RelativeSizeSpan(0.8f), blockStarts[i], blockEnds[i], Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }

        return output;
    }
	 
	 /*
		 * This is nice first word cap
		 * The input string, e.g. "Small Caps"
		 * A formatted SpannableString, e.g. "Sᴍᴀʟʟ Cᴀᴘs"
		 * 
		 * */


    public static SpannableString getSmallCapsStringExactlyText(String input) {
        // values needed to record start/end points of blocks of lowercase letters

        //input=input.toLowerCase();

//				final StringBuilder result = new StringBuilder(input.length());
//				String[] words = input.split("\\s");
//				for(int i=0,l=words.length;i<l;++i) {
//				  if(i>0) result.append(" ");      
//				  result.append(Character.toUpperCase(words[i].charAt(0)))
//				        .append(words[i].substring(1));
//
//				}

        //	input=result.toString();

        char[] chars = input.toCharArray();
        int currentBlock = 0;
        int[] blockStarts = new int[chars.length];
        int[] blockEnds = new int[chars.length];
        boolean blockOpen = false;

        // record where blocks of lowercase letters start/end
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                if (!blockOpen) {
                    blockOpen = true;
                    blockStarts[currentBlock] = i;
                }
                // replace with uppercase letters
                chars[i] = (char) (c - 'a' + '\u0041');
            } else {
                if (blockOpen) {
                    blockOpen = false;
                    blockEnds[currentBlock] = i;
                    ++currentBlock;
                }
            }
        }

        // add the string end, in case the last character is a lowercase letter
        blockEnds[currentBlock] = chars.length;

        // shrink the blocks found above
        SpannableString output = new SpannableString(String.valueOf(chars));
        for (int i = 0; i < Math.min(blockStarts.length, blockEnds.length); ++i) {
            output.setSpan(new RelativeSizeSpan(0.8f), blockStarts[i], blockEnds[i], Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }

        return output;
    }

}
