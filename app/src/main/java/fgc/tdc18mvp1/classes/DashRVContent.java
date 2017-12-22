package fgc.tdc18mvp1.classes;

/**
 * Created by Diksha on 19-12-2017.
 */

public class DashRVContent {
    public String title, subtitle, para, date, venue, card_type, status;
    //private Drawable color_box_primary;

    public DashRVContent(String title, String subtitle, String para, String date, String venue, String card_type, String status) {// //Drawable color_box_primary) {
        this.title = title;
        this.subtitle = subtitle;
        this.para = para;
        this.date = date;
        this.venue = venue;
        this.card_type = card_type;
        this.status = status;
        //this.color_box_primary = color_box_primary;
    }

    //public void closeFile(){
    //  x.close();
    //}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.para = card_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }

    //public Drawable getColor_scheme() {return (color_box_primary);}

    // public void setColor_scheme(Drawable color_box_primary) {this.color_box_primary = color_box_primary;}


}
