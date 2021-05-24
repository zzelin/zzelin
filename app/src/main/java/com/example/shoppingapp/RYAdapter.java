package com.example.shoppingapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class RYAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    //名字数组
    String[] name = new String[]{
            "日用百货1", "日用百货2", "日用百货3", "日用百货4"
    };
    //单价数组
    String[] price = new String[]{
            "1", "2", "3", "4"
    };

    public RYAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder(convertView, position);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(getItem(position).toString());
        holder.price.setText(price[position]);
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView price;
        EditText number;

        public ViewHolder(View view, int pisition) {
            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
            number = (EditText) view.findViewById(R.id.number);
            number.setTag(pisition);//存tag值
            number.addTextChangedListener(new TextSwitcher(this));
        }
    }

    class TextSwitcher implements TextWatcher {
        private ViewHolder mHolder;

        public TextSwitcher(ViewHolder mHolder) {
            this.mHolder = mHolder;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int position = (int) mHolder.number.getTag();//取tag值
            String name = getItem(position).toString();
            ((RYActivity) context).saveEditData(position,s.toString(),name,price[position]);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
