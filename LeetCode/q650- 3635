class Solution {
    public int earliestFinishTime(int[] lst, int[] ldu,
                                 int[] wst, int[] wdu) {

        int ans = Integer.MAX_VALUE;
        int mln = Integer.MAX_VALUE;
        int mnw = Integer.MAX_VALUE;

        for (int i = 0; i < lst.length; i++)
            mln = Math.min(mln, lst[i] + ldu[i]);

        for (int i = 0; i < wst.length; i++)
            ans = Math.min(ans, Math.max(mln, wst[i]) + wdu[i]);

        for (int i = 0; i < wst.length; i++)
            mnw = Math.min(mnw, wst[i] + wdu[i]);

        for (int i = 0; i < lst.length; i++)
            ans = Math.min(ans, Math.max(mnw, lst[i]) + ldu[i]);

        return ans;
    }
}
