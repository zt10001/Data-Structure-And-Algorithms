class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String lPre = strs[0];
        for (int i=1; i<strs.length; i++)
            while (strs[i].indexOf(lPre) != 0)
                // System.out.println(strs[i].indexOf(lPre));
                lPre = lPre.substring(0, lPre.length()-1);
        return lPre;
    }
}