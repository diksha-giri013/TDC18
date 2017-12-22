package fgc.tdc18mvp1.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.classes.DashRVContent;



public class DashRVMainAdapter extends RecyclerView.Adapter<DashRVMainAdapter.MyViewHolder> {
    private static List<DashRVContent> cardContent;
    private DashRVContent card_content;
   // private int adapterPosition;

    //private static String stat;
    public DashRVMainAdapter(List<DashRVContent> cardContent) {
        this.cardContent = cardContent;
    }

    //public int getAdapterPosition() {
      //  return adapterPosition;
    //}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, para, subtitle, date, venue, card_type, status;
        public ImageView color_box_primary, color_box_secondary;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.fdrv_card_title);
            subtitle = (TextView) view.findViewById(R.id.fdrv_card_subtitle);
            para = (TextView) view.findViewById(R.id.fdrv_card_para);
            date = (TextView) view.findViewById(R.id.fdrv_card_date);
            venue = (TextView) view.findViewById(R.id.fdrv_card_venue);
            card_type = (TextView) view.findViewById(R.id.fdrv_card_tv_type);
            status = (TextView) view.findViewById(R.id.fdrc_card_tv_status);
            color_box_primary = (ImageView) view.findViewById(R.id.fdrc_card_iv_boxPrimary);
            color_box_secondary = (ImageView) view.findViewById(R.id.fdrv_card_iv_boxSecondary);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_dash_rv_cardcontent, parent, false);
            return new MyViewHolder(itemView);
        }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        card_content = cardContent.get(position);
        holder.title.setText(card_content.getTitle());
        holder.subtitle.setText(card_content.getSubtitle());
        holder.para.setText(card_content.getPara());
        holder.date.setText(card_content.getDate());
        holder.venue.setText(card_content.getVenue());
        holder.card_type.setText(card_content.getCard_type());
        holder.status.setText(card_content.getStatus());

        //changing card theme according to card type
        if(card_content.card_type=="WORKSHOP") {
            holder.card_type.setTextColor(Color.parseColor("#2e7d32"));
            holder.color_box_primary.setBackgroundColor(Color.parseColor("#00c853"));
            holder.color_box_secondary.setBackgroundColor(Color.parseColor("#1B5E20"));
        }
        else if(card_content.card_type=="UPDATE"){
            holder.card_type.setTextColor(Color.parseColor("#9C0000"));
            holder.color_box_primary.setBackgroundColor(Color.parseColor("#D32F2F"));
            holder.color_box_secondary.setBackgroundColor(Color.parseColor("#9C0000"));
        }
        else if(card_content.card_type=="ARTICLE") {
            holder.card_type.setTextColor(Color.parseColor("#ce8a00"));
            holder.color_box_primary.setBackgroundColor(Color.parseColor("#FFAB00"));
            holder.color_box_secondary.setBackgroundColor(Color.parseColor("#ce8a00"));
        }
        else if(card_content.card_type=="VIDEO"){
            holder.card_type.setTextColor(Color.parseColor("#bc4200"));
            holder.color_box_primary.setBackgroundColor(Color.parseColor("#FF6D00"));
            holder.color_box_secondary.setBackgroundColor(Color.parseColor("#bc4200"));
        }
        //holder.color_box_primary.setImageDrawable(card_content.getColor_scheme());

    }

    public void remove_item(int position) {
        {
            // int position = cardContent.get(position);
            cardContent.remove(position);

        }
    }

    @Override
    public int getItemCount() {
        return cardContent.size();
    }

   }

