package gdut.bsx.tensorflowtraining;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

/**
 * TensorFlowTraining
 *
 * @author baishixian
 * @date 2018/3/13 10:55
 */

public class FileUtil {

    /**
     * 删除或增加图片、视频等媒体资源文件时 通知系统更新媒体库，重新扫描
     * @param filePath 文件路径，包括后缀
     */
    public static void notifyScanMediaFile(Context context, String filePath) {
        if (context == null || TextUtils.isEmpty(filePath)){
            Log.e("FileUtil", "notifyScanMediaFile context is null or filePath is empty.");
            return;
        }

        MediaScannerConnection.scanFile(context, new String[] {filePath}, null, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String path, Uri uri) {
                Log.i("FileUtil", "onScanCompleted");
            }
        });
    }

    public static File getPhotoCacheFolder() {
        File cacheFolder = new File(Environment.getExternalStorageDirectory(), "TensorFlowPhotos");
        if (!cacheFolder.exists()) {
            cacheFolder.mkdirs();
        }
        return cacheFolder;
    }
}
