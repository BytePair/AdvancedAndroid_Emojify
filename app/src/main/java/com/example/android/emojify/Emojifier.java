package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

// COMPLETE (1): Create a Java class called Emojifier
public class Emojifier {

    private static final String TAG = Emojifier.class.getSimpleName();

    /**
     * Method for detecting faces in a bitmap.
     *
     * @param context   The application context.
     * @param bitmap    The picture in which to detect the faces.
     */
    // COMPLETE (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.
    public static void detectFaces(Context context, Bitmap bitmap) {

        // Initialize detector with options for detecting faces with landmarks in a photo
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        // Create Frame instance from the bitmap to supply to the detector
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // The detector can be called synchronously with a frame to detect faces
        SparseArray<Face> faces = detector.detect(frame);

        // Log the number of faces
        Log.d(TAG, "Faces found: " + faces.size());

        // If there are no faces detected, show a Toast message
        if (faces.size() == 0) {
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        detector.release();
    }
}
