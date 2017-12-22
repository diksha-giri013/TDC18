package fgc.tdc18mvp1.fragments;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import fgc.tdc18mvp1.R;

public class DashVPTopFrag extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_dash_vp_top, container, false);

        TextView tv = (TextView) v.findViewById(R.id.DashVPTopFrag_tv_VPHead);
        tv.setText(getArguments().getString("text"));

        TextView subtv = (TextView) v.findViewById(R.id.DashVPTopFrag_tv_VPSubHead);
        subtv.setText(getArguments().getString("text1"));

        ImageView imageViewRight = (ImageView) v.findViewById(R.id.FragDashVPTop_iv_Right);
        imageViewRight.setBackgroundResource(getArguments().getInt("img"));

        return v;
    }

    public static DashVPTopFrag newInstance(String text, String subtext, int img) {

        DashVPTopFrag f = new DashVPTopFrag();
        Bundle b = new Bundle();
        b.putString("text", text);
        b.putString("text1", subtext);
        b.putInt("img", img);
       f.setArguments(b);

        return f;
    }
}
