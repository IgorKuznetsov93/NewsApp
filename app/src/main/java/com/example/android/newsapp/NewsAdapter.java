package com.example.android.newsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Result> results;
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();


    public NewsAdapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_child, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            Result result = results.get(position);
            String imageUrl = Html.fromHtml(result.getFields().getThumbnail()).toString();
            new DownloadImageTask((ImageView) holder.thumbnailImage).execute(imageUrl);
            holder.sectionTextView.setText(Html.fromHtml(result.getSectionName()));
            holder.articleTitleTextView.setText(Html.fromHtml(result.getWebTitle()));
            holder.publishTimeTextView.setText(Html.fromHtml(formatPublishTime(result.getFields().getFirstPublicationDate())));
        }
        catch (NullPointerException e){
            Log.e(LOG_TAG, "проблема с наполнением");
        }
    }

    @Override
    public int getItemCount() {
        if (results == null)
            return 0;
        return results.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnailImage;
        TextView sectionTextView;
        TextView articleTitleTextView;
        TextView publishTimeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            thumbnailImage = itemView.findViewById(R.id.article_thumbnail_image_view);
            sectionTextView = itemView.findViewById(R.id.article_section_text_view);
            articleTitleTextView = itemView.findViewById(R.id.article_title_text_view);
            publishTimeTextView = itemView.findViewById(R.id.article_publish_time_text_view);
        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urlDisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Ошибка передачи", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    private String formatPublishTime(final String time) {

        String rTime = "N.A.";

        if ((time != null) && (!time.isEmpty())) {
            try {

                SimpleDateFormat currentSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

                SimpleDateFormat newSDF = new SimpleDateFormat("yyyy.MM.dd");

                rTime = newSDF.format(currentSDF.parse(time));
            } catch (ParseException parseEx) {

                rTime = "N.A.";

                Log.e(LOG_TAG, "Error while parsing the published date", parseEx);
            }
        }

        return rTime;
    }
}
