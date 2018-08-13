package com.example.vivianbabiryekulumba.townhall.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.models.Event;

public class EventViewHolder extends RecyclerView.ViewHolder{

    private TextView event_title;
    private TextView event_content;

    public EventViewHolder(View itemView) {
        super(itemView);

        event_title = itemView.findViewById(R.id.event_title_tv);
        event_content = itemView.findViewById(R.id.event_content_tv);
    }

    public void setEvent(Event event) {
        event_title.setText(event.getEvent_title());
        event_content.setText(event.getEvent_content());
    }
}
