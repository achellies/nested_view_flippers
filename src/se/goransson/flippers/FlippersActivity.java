package se.goransson.flippers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class FlippersActivity extends Activity implements OnGestureListener {

	private GestureDetector gestureScanner;
	private ViewFlipper rootFlipper;
	private ViewFlipper flipper1, flipper2;

	private Animation animFlipInNext, animFlipOutNext;
	private Animation animFlipInPrevious, animFlipOutPrevious;
	private Animation rootAnimFlipInNext, rootAnimFlipOutNext;
	private Animation rootAnimFlipInPrevious, rootAnimFlipOutPrevious;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Root flipper
		rootFlipper = (ViewFlipper) findViewById(R.id.rootFlipper);

		// Content flippers
		flipper1 = (ViewFlipper) findViewById(R.id.viewFlipper1);
		flipper2 = (ViewFlipper) findViewById(R.id.viewFlipper2);

		gestureScanner = new GestureDetector(this);

		// Animations
		animFlipInNext = AnimationUtils.loadAnimation(this, R.anim.flipinnext);
		animFlipOutNext = AnimationUtils.loadAnimation(this, R.anim.flipoutnext);
		animFlipInPrevious = AnimationUtils.loadAnimation(this,
				R.anim.flipinprevious);
		animFlipOutPrevious = AnimationUtils.loadAnimation(this,
				R.anim.flipoutprevious);

		rootAnimFlipInNext = AnimationUtils.loadAnimation(this,
				R.anim.rootflipinnext);
		rootAnimFlipOutNext = AnimationUtils.loadAnimation(this,
				R.anim.rootflipoutnext);
		rootAnimFlipInPrevious = AnimationUtils.loadAnimation(this,
				R.anim.rootflipinprevious);
		rootAnimFlipOutPrevious = AnimationUtils.loadAnimation(this,
				R.anim.rootflipoutprevious);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureScanner.onTouchEvent(event);
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {

		Log.i("TEST", "Fling!!");

		if (Math.abs(velocityY) > Math.abs(velocityX)) {
			if (velocityY > 0) {
				rootFlipper.setInAnimation(rootAnimFlipInNext);
				rootFlipper.setOutAnimation(rootAnimFlipOutNext);
				rootFlipper.showNext();
			} else if (velocityY < 0) {
				rootFlipper.setInAnimation(rootAnimFlipInPrevious);
				rootFlipper.setOutAnimation(rootAnimFlipOutPrevious);
				rootFlipper.showPrevious();
			}
		} else {
			if (velocityX > 0) {
				ViewFlipper v = (ViewFlipper) rootFlipper.getCurrentView();
				v.setInAnimation(animFlipInNext);
				v.setOutAnimation(animFlipOutNext);
				v.showNext();
			} else if (velocityX < 0) {
				ViewFlipper v = (ViewFlipper) rootFlipper.getCurrentView();
				v.setInAnimation(animFlipInPrevious);
				v.setOutAnimation(animFlipOutPrevious);
				v.showPrevious();
			}
		}
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}