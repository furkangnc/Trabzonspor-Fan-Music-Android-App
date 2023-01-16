package club.furk4n.furkanodev;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    GestureDetector mGestureDedector;
    private OnItemClickListener mListener;

    public RecyclerItemClickListener(Context context, OnItemClickListener onItemClickListener) {
        this.mListener = (OnItemClickListener) onItemClickListener;
        this.mGestureDedector = new GestureDetector(context, (GestureDetector.OnGestureListener) new GestureDetector.SimpleOnGestureListener() {
           public boolean onSingleTapUp(MotionEvent motionEvent) {
               return true;
           }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView,MotionEvent motionEvent) {
        View view = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if (view != null && this.mListener != null && this.mGestureDedector.onTouchEvent(motionEvent)) {
            this.mListener.onItemClick(view, recyclerView.getChildAdapterPosition(view));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView,MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public static interface OnItemClickListener {
        public void onItemClick(View view1, int position);
    }
}
