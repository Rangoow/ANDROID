package worldline.ssm.rd.ux.wltwitter.async;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import worldline.ssm.rd.ux.wltwitter.helpers.TwitterHelper;

public class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private  final ImageView mImageView;

    public DownloadImageAsyncTask(ImageView mImageView) {
        this.mImageView = mImageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        if ((null != strings) && (strings.length>0))
        {
            final String imageUrl = strings[0];
            try{

                final Bitmap bitmap= TwitterHelper.getTwitterUserImage(imageUrl);
                return  bitmap;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if((null!=bitmap) && (null!=mImageView))
            mImageView.setImageBitmap(bitmap);
        super.onPostExecute(bitmap);
    }
}
