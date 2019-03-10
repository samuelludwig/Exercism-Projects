using System;

public static class Pangram
{
    public static bool IsPangram(string input)
    {
        char[] alpha = new char[26];
        int initASCIINum = 97;
        for(int i = 0; i < alpha.Length; i++) {
            alpha[i] = Convert.ToChar(i + initASCIINum);
        } //Programmatically creating the alphabet because I am lazy

        char[] str = input.ToLower().ToCharArray();

        int lettersFound = 0;
        for(int i = 0; i < alpha.Length; i++) {
            if(Array.Exists(str, element => element == alpha[i])) {
                lettersFound++;
            }
        }

        if(lettersFound == 26) {
            return true;
        } else {
            return false;
        }
    }
}
