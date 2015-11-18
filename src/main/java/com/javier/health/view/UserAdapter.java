package com.javier.health.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.javier.health.R;
import com.javier.health.models.User;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class UserAdapter extends ArrayAdapter<User> {
    private final Context mContext;
    private final List<User> mList;

    public UserAdapter(Context context, List<User> list) {
        super(context, -1, list);
        this.mContext = context;
        this.mList = list;
    }

    static class ViewHolder {
        public TextView name;
        public TextView surname;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_user, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) rowView.findViewById(R.id.row_user_name_text_view);
            viewHolder.surname = (TextView) rowView.findViewById(R.id.row_user_surname_text_view);
            rowView.setTag(viewHolder);
        }
        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.name.setText(mList.get(position).getFirstName());
        holder.surname.setText(mList.get(position).getSurname());
        return rowView;
    }

}
