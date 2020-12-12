package com.example.knowthetrend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.MyViewHolder>{
    Context context;
    List<List<DataEntry>> chartlist;
    List<String> text;

    public ChartAdapter(Context context, List<List<DataEntry>> chartlist, List<String> text) {
        this.context = context;
        this.chartlist = chartlist;
        this.text=text;
    }

    @NonNull
    @Override
    public ChartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.chart_item,parent,false);
        return new ChartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChartAdapter.MyViewHolder holder, int position) {
        Cartesian cartesian= AnyChart.column();
        Column column=cartesian.column(chartlist.get(position));
        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        //cartesian.title("Top Trends");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title(text.get(position).substring(4));
        cartesian.yAxis(0).title("Trending %");
        holder.anyChartView.setChart(cartesian);
        holder.textView.setText(text.get(position));
    }

    @Override
    public int getItemCount() {
        return chartlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AnyChartView anyChartView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            anyChartView=itemView.findViewById(R.id.any_chart_view);
            textView=itemView.findViewById(R.id.chart_type);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,ChartListActivity.class);
                    intent.putExtra("POS",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
