package eu.jonbo.zcalendar;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import eu.jonbo.zcalendar.utils.ExtendedCalendar;

public class MainActivity extends AppCompatActivity  {

    private ConstraintLayout mMainLayout;
    private PanelHeader mPanelHeader;
    private android.app.ActionBar mActionBar;


    public MainActivity() {
//        mMenuHandler = new MenuHandler();
//
//        HandlerThread ht = new HandlerThread("Event observer");
//        ht.start();
//        mEventContentObserver = new EventContentObserver(new Handler(ht.getLooper()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mMainLayout = (ConstraintLayout) findViewById(R.id.content_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPanelHeader = (PanelHeader)findViewById(R.id.header);

//        String[] calViews = getResources().getStringArray(R.array.calendarviews);
//        ActionbarSpinnerItem[] objects = new ActionbarSpinnerItem[calViews.length];
//        for (int i = 0; i < calViews.length; i++) {
//            objects[i] = new ActionbarSpinnerItem();
//            objects[i].viewType = calViews[i];
//        }
//
//        mActionbarSpinnerAdapter = new ActionbarSpinnerAdapter(this, R.layout.actionbar_spinner_drowdown, objects);

//        mActionBar = getActionBar();
//        mActionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_LIST);
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//        mActionBar.setListNavigationCallbacks(mActionbarSpinnerAdapter, this);

        /*
        mCurrentTheme = PreferenceHandler.getAppTheme(this, 0);
	    if (mCurrentTheme == 0) {
	    	getApplication().setTheme(R.style.CalendarLightTheme);
	    	setTheme(R.style.CalendarLightTheme);
		}
	    if (mCurrentTheme == 1) {
	    	getApplication().setTheme(R.style.CalendarDarkTheme);
	    	setTheme(R.style.CalendarDarkTheme);
	    }


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Configuration.BITMAP_CACHE_MAX_WIDTH = metrics.widthPixels;
        Configuration.BITMAP_CACHE_MAX_HEIGHT = metrics.heightPixels;


        if (mCurrentTheme == 0) {
        	mMainLayout.setBackgroundColor(Color.parseColor("#ffe8e8e8"));
        }


        long currentCallendarTime = 0;

        Intent intent = getIntent();
        if (intent != null && ACTION_DISPLAY_EVENT.equals(intent.getAction())) {
        	List<String> pathSegments = intent.getData().getPathSegments();
        	if (pathSegments.size() == 2 && "time".equals(pathSegments.get(0))) {
    			try {
    				currentCallendarTime = Long.parseLong(pathSegments.get(1));
    			} catch (NumberFormatException e) {
    				currentCallendarTime = 0;
    			}
    		} else {
	        	mEvent = getEventFromIntent(intent);
	        	if (mEvent != null) {
	        		currentCallendarTime = mEvent.start;
	        	}
    		}
        	intent.setAction(null);
        	setIntent(intent);
        }

        int selectedNavigationItem = PreferenceHandler.getLastUsedView(this, Configuration.WEEK_VIEW);

        boolean searchVisible = false;

        if (savedInstanceState != null) {
        	selectedNavigationItem = savedInstanceState.getInt(INSTANCE_STATE_SELECTED_NAVIGATION_INDEX, 2);
        	currentCallendarTime = savedInstanceState.getLong(INSTANCE_STATE_CURRENT_CALENDAR, 0);
        	searchVisible = savedInstanceState.getBoolean(INSTANCE_STATE_IS_SEARCH_VISIBLE, false);
        }

        mActionBar.setSelectedNavigationItem(selectedNavigationItem);

        ExtendedCalendar calendar = ExtendedCalendar.getInstance();
        if (currentCallendarTime != 0)
        	calendar.setTimeInMillis(currentCallendarTime);
        mCalendarTime = calendar.getTimeInMillis();

        mSavedInstanceState = savedInstanceState;

        if (searchVisible) {
        	setAgendaView(true);
        	if (mAgendaController != null) {
        		mAgendaController.onRestoreSaveInstanceState(savedInstanceState);
        		mSavedInstanceState = null;
        	}
		}


        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_month:
                Toast.makeText(this, "Month", Toast.LENGTH_SHORT).show();
                setMonthView();
                break;
            default:
                break;
        }
        return true;
    }

    private ExtendedCalendar getCurrentCalendar() {
        ExtendedCalendar calendar = null;

//        if (mCurrentPanel != null)
//            calendar = mCurrentPanel.getCurrentCalendar();
//        else if (mAgendaController != null)
//            calendar = mAgendaController.getCurrentCalendar();
//
//        if (mCalendarTime == -1) {
//            switch (getCurrentViewMode()) {
//                case Configuration.YEAR_VIEW:
//                    break;
//                case Configuration.MONTH_VIEW:
//                    break;
//                case Configuration.WEEK_VIEW:
//                    break;
//                case Configuration.DAY_VIEW:
//                    WeekView weekView = (WeekView) mCurrentPanel.getCurrentView();
//                    int col = weekView.getDayColumn();
//                    calendar.addDays(col);
//                    break;
//                case Configuration.AGENDA_VIEW:
//                    break;
//            }
//        } else {
//            if (calendar == null)
//                calendar = ExtendedCalendar.getInstance();
//            calendar.setTimeInMillis(mCalendarTime);
//            mCalendarTime = -1;
//        }

        if (calendar == null) {
            calendar = ExtendedCalendar.getInstance();
        }

        return calendar;
    }

    private int getCurrentViewMode() {
//        if (mCurrentPanel != null) {
//            return ((PanelView)mCurrentPanel.getCurrentView()).getViewMode();
//        } else if (mPanelAgenda != null){
//            return Configuration.AGENDA_VIEW;
//        }

        return -1;
    }

    public void setMonthView() {
//        if (getCurrentViewMode() == Configuration.MONTH_VIEW)
//            return;

        ExtendedCalendar calendar = getCurrentCalendar();
        //showPanel(Configuration.MONTH_VIEW, calendar, mAnimateNextViewChange);
        //mAnimateNextViewChange = false;
    }
}

/*


public class CalendarActivity extends Activity implements Panel.Listener, OnNavigationListener, AgendaController.Listener, CalendarDialog.CloseListener, CalendarAppHandler.Listener {

	private static final String AD_UNIT_ID = "ca-app-pub-1677983635491366/6066010332";
	public static final String ACTION_DISPLAY_EVENT = "android.intent.action.VIEW";

	public static final String EVENT_ID_KEY = "eventid";
	public static final String EVENT_TITLE_KEY = "title";
	public static final String EVENT_START_KEY = "start";
	public static final String EVENT_END_KEY = "end";
	public static final String EVENT_CALENDARID_KEY = "calendarid";
	public static final String EVENT_LOCATION_KEY = "location";
	public static final String EVENT_ALLDAY_KEY = "allday";

	private static final String INSTANCE_STATE_SELECTED_NAVIGATION_INDEX = "CalendarActivity_SelectedNavigationIndex";
	private static final String INSTANCE_STATE_CURRENT_CALENDAR = "CalendarActivity_CurrentCalendar";
	private static final String INSTANCE_STATE_IS_SEARCH_VISIBLE = "CalendarActivity_SearchVisibility";

	private static final int SWITCH_VIEW_ANIMATION_DURATION = 200;
	private static final long OBSERVER_DELAY = 2000;
	private static final String LOG_TAG = "CalendarActivity";

	private Panel mCurrentPanel;
	private RelativeLayout mMainLayout;
	private CalendarDialog mCalendarDialog;
	private ActionbarSpinnerAdapter mActionbarSpinnerAdapter;
	private View mPanelAgenda;
	private AgendaController mAgendaController;
	private ActionBar mActionBar;
	private long mCalendarTime = -1;
	private Bundle mSavedInstanceState;
	private boolean mAnimateNextViewChange;
	private ActionMode mActionMode;
	private SearchView mSearchView;
	private MenuItem mMenuSearchItem;
	private BaseEvent mEvent;
	private MenuHandler mMenuHandler;
	private int mCurrentTheme;
	private String mCurrentFirstDayOfWeek;
	private EventContentObserver mEventContentObserver;

	private PanelHeader mPanelHeader;
	private AdView mAdView;



	@Override
	public void createEvent(long start, long end) {
		startActivity(GetCreateEventIntent(start, end));
	}

	private long getDefaultCreateEventStart(ExtendedCalendar calendar) {
		long result = 0;
		PanelView panelView = (PanelView) mCurrentPanel.getCurrentView();
		if (panelView.isInitialized()) {
			long millis = calendar.getTimeInMillis();

			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 12);
			result = calendar.getTimeInMillis();
			calendar.setTimeInMillis(millis);
		} else {
			result = ExtendedCalendar.getInstance().getTimeInMillis();
		}

		return result;
	}

	private Intent GetCreateEventIntent() {
		long start = 0;
		long end = 0;

		if (mCurrentPanel != null) {
			PanelView panelView = (PanelView) mCurrentPanel.getCurrentView();
			if (panelView.isInitialized()) {

				ExtendedCalendar calendar = panelView.getCalendar();
				switch (panelView.getViewMode()) {
				case Configuration.YEAR_VIEW:
					if (!calendar.isCurrentYear()) {
						start = getDefaultCreateEventStart(calendar);
					}
					break;
				case Configuration.MONTH_VIEW:
					if (panelView instanceof MonthView) {
						MonthView monthView = (MonthView) panelView;
						if (monthView.IsClickToAddEventEnabled()) {
							start = monthView.GetClickToAddEventStart();
							end = monthView.GetClickToAddEventEnd();
						} else if (!calendar.isCurrentMonth()) {
							start = getDefaultCreateEventStart(calendar);
						}
					}
					break;
				case Configuration.WEEK_VIEW:
					if (panelView instanceof WeekView) {
						WeekView weekView = (WeekView) panelView;
						if (weekView.IsClickToAddEventEnabled()) {
							start = weekView.GetClickToAddEventStart();
							end = weekView.GetClickToAddEventEnd();
						} else if (!calendar.isCurrentWeek()) {
							start = getDefaultCreateEventStart(calendar);
						}
					}
					break;
				case Configuration.DAY_VIEW:
					if (panelView instanceof WeekView) {
						WeekView weekView = (WeekView) panelView;
						if (weekView.IsClickToAddEventEnabled()) {
							start = weekView.GetClickToAddEventStart();
							end = weekView.GetClickToAddEventEnd();
						} else {
							int dayNr = weekView.getDayViewColumn();
							if (dayNr != -1) {
								long millis = calendar.getTimeInMillis();
								calendar.addDays(dayNr);
								if (!calendar.isToday()) {
									start = getDefaultCreateEventStart(calendar);
								}
								calendar.setTimeInMillis(millis);
							}
						}
					}
					break;
				}

				if (start != 0 && end == 0) {
					end = start + ExtendedCalendar.MILLIS_IN_ONE_HOUR;
				}
			}
		}

		return GetCreateEventIntent(start, end);
	}

	private Intent GetCreateEventIntent(long start, long end) {
		Intent intent = new Intent(CalendarActivity.this, EventActivity.class);

		intent.putExtra(EventActivity.INTENT_EXTRA_EVENT_START, start);
		intent.putExtra(EventActivity.INTENT_EXTRA_EVENT_END, end);

		return intent;
	}

	private class EventContentObserver extends ContentObserver {

		private Timer mTimer;

		private class Task extends TimerTask {

			private Runner mRunner;

			public Task() {
				mRunner = new Runner();
			}

			private class Runner implements Runnable {

				@Override
				public void run() {
					if (Configuration.LOG_DEBUG)
						Log.d(Configuration.LOG_TAG, "Observer timer  triggered, calling reQuery");
					reQueryCurrentView();
					if (mTimer != null) {
						mTimer.cancel();
						mTimer = null;
					}
				}
			}

			@Override
			public void run() {
				runOnUiThread(mRunner);
			}
		}

		public EventContentObserver(Handler handler) {
			super(handler);
		}

		@Override
		public void onChange(boolean selfChange) {
			if (mTimer != null)
				mTimer.cancel();
			mTimer = new Timer();
			mTimer.schedule(new Task(), OBSERVER_DELAY);

			if (Configuration.LOG_DEBUG)
				Log.d(Configuration.LOG_TAG, "on change received, restarting delay timer");
		}

		public void onPause() {
			if (mTimer != null) {
				mTimer.cancel();
				mTimer = null;
			}

			getContentResolver().unregisterContentObserver(this);
		}

		public void onResume() {
			getContentResolver().registerContentObserver(
	                CalendarContract.Events.CONTENT_URI, true, this);
		}
	}

	public CalendarActivity() {
		mMenuHandler = new MenuHandler();

		HandlerThread ht = new HandlerThread("Event observer");
		ht.start();
		mEventContentObserver = new EventContentObserver(new Handler(ht.getLooper()));
	}

	@Override
	public void onScroll(int xPos) {
		mPanelHeader.updateTextPositions(xPos);
	}

	@Override
	protected void onNewIntent(Intent intent) {
        if (intent != null && ACTION_DISPLAY_EVENT.equals(intent.getAction())) {
        	BaseEvent event = getEventFromIntent(intent);
        	if (event != null)
        		showCalendarDialog(R.layout.event_dialog, event);
        }
	}

	private BaseEvent getEventFromIntent(Intent intent) {
		BaseEvent event = new BaseEvent();

		List<String> pathSegments = intent.getData().getPathSegments();
		if (pathSegments.size() == 2 && "events".equals(pathSegments.get(0))) {
			try {
				event.id = Long.parseLong(pathSegments.get(1));
			} catch (NumberFormatException e) {
				return null;
			}
		} else {
			event.id = intent.getLongExtra(EVENT_ID_KEY, -1);
			String title = intent.getStringExtra(EVENT_TITLE_KEY);
			if (title != null)
				event.title = title.toCharArray();
			event.start = intent.getLongExtra(EVENT_START_KEY, -1);
			event.end = intent.getLongExtra(EVENT_END_KEY, -1);
			event.calendarId = intent.getLongExtra(EVENT_CALENDARID_KEY, -1);
			String location = intent.getStringExtra(EVENT_LOCATION_KEY);
			if (location != null)
				event.location = location.toCharArray();
			event.allDay = intent.getBooleanExtra(EVENT_ALLDAY_KEY, false);

	        if (event.id == -1 || event.start == -1 || event.end == -1) {
	        	if (Configuration.LOG_DEBUG) {
	        		if (event.id == -1)
	        			Log.d(Configuration.LOG_TAG, "eventId not set in intent");
	        		if (event.start == -1)
	        			Log.d(Configuration.LOG_TAG, "start not set in intent");
	        		if (event.end == -1)
	        			Log.d(Configuration.LOG_TAG, "end not set in intent");
	        	}
	        	return null;
	        }
		}
		return event;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(INSTANCE_STATE_SELECTED_NAVIGATION_INDEX,  mActionBar.getSelectedNavigationIndex());
		outState.putLong(INSTANCE_STATE_CURRENT_CALENDAR,  getCurrentCalendar().getTimeInMillis());
		if (mMenuSearchItem != null)
			outState.putBoolean(INSTANCE_STATE_IS_SEARCH_VISIBLE,  mMenuSearchItem.isActionViewExpanded());
		else
			outState.putBoolean(INSTANCE_STATE_IS_SEARCH_VISIBLE,  false);
		if (mCurrentPanel != null) {
			mCurrentPanel.onSaveInstanceState(outState);
		} else if (mAgendaController != null) {
			mAgendaController.onSaveInstanceState(outState);
		}
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		Bundle savedInstanceState = null;
		if (mSavedInstanceState != null) {
			savedInstanceState = mSavedInstanceState;
			mSavedInstanceState = null;
		}

		if (itemPosition == 0)
			setYearView();
		else if (itemPosition == 1)
			setMonthView();
		else if (itemPosition == 2)
			setWeekView();
		else if (itemPosition == 3)
			setDayView();
		else if (itemPosition == 4)
			setAgendaView(false);

		if (mCurrentPanel != null && savedInstanceState != null)
			mCurrentPanel.onRestoreSaveInstanceState(savedInstanceState);
		if (mAgendaController != null && savedInstanceState != null)
			mAgendaController.onRestoreSaveInstanceState(savedInstanceState);

    	if (mEvent != null) {
    		showCalendarDialog(R.layout.event_dialog, mEvent);
    		mEvent = null;
    	}

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    return mMenuHandler.onMenuItemSelected(featureId, item);
	}

	public void restartActivity() {
	    Intent intent = getIntent();
	    overridePendingTransition(0, 0);
	    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	    onPause();
	    onDestroy();
	    finish();

	    overridePendingTransition(0, 0);
	    startActivity(intent);
	}

	@Override
	public void doShowEventDialog(BaseEvent event) {
		showCalendarDialog(R.layout.event_dialog, event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onStart() {
		if (mCurrentPanel != null)
			mCurrentPanel.onStart();
		super.onStart();
	}

	@Override
	protected void onStop() {
		closeCalendarDialog(false);
		if (mCurrentPanel != null)
			mCurrentPanel.onStop();
		super.onStop();
	}

	@Override
	protected void onPause() {
		if (mAdView != null) {
			mAdView.pause();
		}

		if (mCurrentPanel != null)
			mCurrentPanel.onPause();
		if (mAgendaController != null)
			mAgendaController.onPause();
		mEventContentObserver.onPause();

		//closeCalendarDialog(false);

		if (getApplicationContext() instanceof CalendarAppHandler) {
			((CalendarAppHandler)getApplicationContext()).setListener(null);
		}

		super.onPause();
	}

	@Override
	protected void onResume() {
		if (mAdView != null) {
			mAdView.resume();
	    }

		if (mCurrentTheme != PreferenceHandler.getAppTheme(CalendarActivity.this, -1)) {
			restartActivity();
		}

		String firstDayOfWeek = PreferenceHandler.getFirstDayOfWeek(CalendarActivity.this, "_0");
		if (!firstDayOfWeek.equals(mCurrentFirstDayOfWeek)) {
			mCurrentFirstDayOfWeek = firstDayOfWeek;
			setFirstDayOfWeek();
		}

		if (mCurrentPanel != null)
			mCurrentPanel.onResume();
		if (mAgendaController != null)
			mAgendaController.onResume();

		mEventContentObserver.onResume();

		if (getApplicationContext() instanceof CalendarAppHandler) {
			((CalendarAppHandler)getApplicationContext()).setListener(this);
		}

		super.onResume();
	}

	@Override
	public void onSwitchView() {
		setPanelHeaderDateTitle();
	}

	@Override
	public void onInitialized() {
		setPanelHeaderDateTitle();
	}

	@Override
	public void onViewModeChanged(int viewType) {
		setPanelHeaderDateTitle();
		setNavigationToView(viewType);
	}

	private void setPanelHeaderDateTitle() {
		if (mPanelHeader.getVisibility() != View.VISIBLE)
			return;

		String prevprevdate = "";
		String prevdate = "";
		String curdate = "";
		String nextdate = "";
		String nextnextdate = "";

		ExtendedCalendar currentCal = getCurrentCalendar();

		if (mCurrentPanel != null) {
			PanelView panelView = (PanelView) mCurrentPanel.getCurrentView();
			if (panelView.isInitialized()) {
				switch (panelView.getViewMode()) {
				case Configuration.YEAR_VIEW:
					currentCal.add(Calendar.YEAR, -2);
					prevprevdate = DateFormater.getYear(currentCal);

					currentCal.add(Calendar.YEAR, 1);
					prevdate = DateFormater.getYear(currentCal);

					currentCal.add(Calendar.YEAR, 1);
					curdate = DateFormater.getYear(currentCal);

					currentCal.add(Calendar.YEAR, 1);
					nextdate = DateFormater.getYear(currentCal);

					currentCal.add(Calendar.YEAR, 1);
					nextnextdate = DateFormater.getYear(currentCal);
					break;
				case Configuration.MONTH_VIEW:
					currentCal.add(Calendar.MONTH, -2);
					prevprevdate = DateFormater.getDateNoDay(this, currentCal.getTimeInMillis());

					currentCal.add(Calendar.MONTH, 1);
					prevdate = DateFormater.getDateNoDay(this, currentCal.getTimeInMillis());

					currentCal.add(Calendar.MONTH, 1);
					curdate = DateFormater.getDateNoDay(this, currentCal.getTimeInMillis());

					currentCal.add(Calendar.MONTH, 1);
					nextdate = DateFormater.getDateNoDay(this, currentCal.getTimeInMillis());

					currentCal.add(Calendar.MONTH, 1);
					nextnextdate = DateFormater.getDateNoDay(this, currentCal.getTimeInMillis());
					break;
				case Configuration.WEEK_VIEW:
					currentCal.setCalendarToFirstDayInWeek();
					currentCal.addMillis(-1);
					currentCal.setCalendarToFirstDayInWeek();
					currentCal.addMillis(-1);
					currentCal.setCalendarToFirstDayInWeek();

					long from = currentCal.getTimeInMillis();
					currentCal.setCalendarToLastDayInWeek();
					long to = currentCal.getTimeInMillis();
					prevprevdate = DateFormater.getRange(getApplicationContext(), from, to, false, true);

					currentCal.addMillis(1);
					from = currentCal.getTimeInMillis();
					currentCal.setCalendarToLastDayInWeek();
					to = currentCal.getTimeInMillis();
					prevdate = DateFormater.getRange(getApplicationContext(), from, to, false, true);

					currentCal.addMillis(1);
					from = currentCal.getTimeInMillis();
					currentCal.setCalendarToLastDayInWeek();
					to = currentCal.getTimeInMillis();
					curdate = DateFormater.getRange(getApplicationContext(), from, to, false, true);

					currentCal.addMillis(1);
					from = currentCal.getTimeInMillis();
					currentCal.setCalendarToLastDayInWeek();
					to = currentCal.getTimeInMillis();
					nextdate = DateFormater.getRange(getApplicationContext(), from, to, false, true);

					currentCal.addMillis(1);
					from = currentCal.getTimeInMillis();
					currentCal.setCalendarToLastDayInWeek();
					to = currentCal.getTimeInMillis();
					nextnextdate = DateFormater.getRange(getApplicationContext(), from, to, false, true);
					break;
				case Configuration.DAY_VIEW:
					currentCal.setCalendarToFirstDayInWeek();
					currentCal.addDays(((WeekView)mCurrentPanel.getCurrentView()).getDayViewColumn());

					currentCal.add(Calendar.DAY_OF_YEAR, -2);
					prevprevdate = DateFormater.getLongDate(currentCal.getTimeInMillis());

					currentCal.add(Calendar.DAY_OF_YEAR, 1);
					prevdate = DateFormater.getLongDate(currentCal.getTimeInMillis());

					currentCal.add(Calendar.DAY_OF_YEAR, 1);
					curdate = DateFormater.getLongDate(currentCal.getTimeInMillis());

					currentCal.add(Calendar.DAY_OF_YEAR, 1);
					nextdate = DateFormater.getLongDate(currentCal.getTimeInMillis());

					currentCal.add(Calendar.DAY_OF_YEAR, 1);
					nextnextdate = DateFormater.getLongDate(currentCal.getTimeInMillis());
					break;

				}
			} else {
				return;
			}
		} else if (mAgendaController != null) {
			//date = DateFormater.getDateNoYear(currentCal.getTimeInMillis());
		}

		mPanelHeader.setText(prevprevdate, prevdate, curdate, nextdate, nextnextdate);
	}



	private void setFirstDayOfWeek() {

	    if (mCurrentPanel != null) {
	    	ExtendedCalendar calendar = mCurrentPanel.getCurrentCalendar();
	    	int viewMode = getCurrentViewMode();
	    	switch (viewMode) {
	    	case Configuration.WEEK_VIEW:
	    		int week = calendar.get(Calendar.WEEK_OF_YEAR);
	    		calendar.setCalendarToFirstDayInWeek();
	    		calendar.set(Calendar.WEEK_OF_YEAR, week);
	    		break;
	    	case Configuration.DAY_VIEW:
	    		int col = ((WeekView)mCurrentPanel.getCurrentView()).getDayColumn();
	    		long millis = calendar.getTimeInMillis();

	    		week = calendar.get(Calendar.WEEK_OF_YEAR);
	    		calendar.setCalendarToFirstDayInWeek();
	    		calendar.set(Calendar.WEEK_OF_YEAR, week);
	    		int change = FastMath.round((millis - calendar.getTimeInMillis())/ExtendedCalendar.MILLIS_IN_ONE_DAY);

	    		if (col + change >= 0 && col + change < 7) {
	    			col += change;
	    		} else if (col + change >= 7) {
	    			col += change;
	    			col -= 7;
	    			calendar.addDays(7);
	    		} else if (col + change < 0) {
	    			col += change;
	    			col += 7;
	    			calendar.addDays(-7);
	    		}

	    		if (col > 6)
	    			col = 6;
	    		if (col < 0)
	    			col = 0;

	    		((WeekView)mCurrentPanel.getCurrentView()).setDayColumn(col);
	    		break;
	    	}
	    	((PanelView)mCurrentPanel.getCurrentView()).setCalendar(calendar);
	    }
	}

	private void showPanel(int viewType, ExtendedCalendar calendar, boolean animate) {
		if (mCalendarDialog != null) {
			closeCalendarDialog(false);
    	}

		mPanelHeader.setVisibility(View.VISIBLE);

		Panel panel = null;
		LayoutInflater inflater = getLayoutInflater();
		switch (viewType) {
		case Configuration.YEAR_VIEW:
			panel = (Panel) inflater.inflate(R.layout.panel_year, mMainLayout, false);
			break;
		case Configuration.MONTH_VIEW:
			panel = (Panel) inflater.inflate(R.layout.panel_month, mMainLayout, false);
			break;
		case Configuration.WEEK_VIEW:
			panel = (Panel) inflater.inflate(R.layout.panel_week, mMainLayout, false);
			break;
		case Configuration.DAY_VIEW:
			panel = (Panel) inflater.inflate(R.layout.panel_week, mMainLayout, false);
			break;
		}

		panel.setVisibility(View.VISIBLE);
		panel.setListener(this);
		mMainLayout.addView(panel);

		if (calendar != null) {
			if (Configuration.LOG_CALENDAR)
				Log.d(Configuration.LOG_TAG, "Changing view, calendar:"+calendar.toString());

			((PanelView)panel.getCurrentView()).setCalendar(calendar);
		}

		panel.onResume();

		if (animate) {
			ScaleAnimation animation = new ScaleAnimation(0, 1, 0, 1, mMainLayout.getWidth()/2, mMainLayout.getHeight()/2);
			animation.setDuration(SWITCH_VIEW_ANIMATION_DURATION);
			final Panel setPanel = panel;
			animation.setAnimationListener(new AnimationListener() {
				@Override
				public void onAnimationStart(Animation animation) {
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					if (mCurrentPanel != null) {
						mCurrentPanel.onPause();
						final Panel removePanel = mCurrentPanel;
						new Handler().post(new Runnable() {
					        public void run() {
					        	if (mMainLayout != null)
					        		mMainLayout.removeView(removePanel);
					        }
					    });

					}
					mCurrentPanel = setPanel;
					setPanelHeaderDateTitle();
				}
			});
			panel.startAnimation(animation);
		} else {
			if (mCurrentPanel != null) {
				mCurrentPanel.onPause();
				mMainLayout.removeView(mCurrentPanel);
			}
			if (mAgendaController != null) {
				mAgendaController.onDestroy();
				mMainLayout.removeView(mPanelAgenda);
				mPanelAgenda = null;
				mAgendaController = null;
			}
			mCurrentPanel = panel;
			setPanelHeaderDateTitle();
		}

		if (mAdView != null) {
			mAdView.bringToFront();
		}

	}

	public void setYearView() {
		if (getCurrentViewMode() == Configuration.YEAR_VIEW)
			return;

		ExtendedCalendar calendar = getCurrentCalendar();
		showPanel(Configuration.YEAR_VIEW, calendar, false);
	}



	public void setWeekView() {
		if (getCurrentViewMode() == Configuration.WEEK_VIEW)
			return;

		if (getCurrentViewMode() == Configuration.DAY_VIEW) {
			WeekView weekView = (WeekView) mCurrentPanel.getCurrentView();
			weekView.setWeekView(true);
		} else {
			showPanel(Configuration.WEEK_VIEW, getCurrentCalendar(), false);
		}

	}

	public void setDayView() {
		if (getCurrentViewMode() == Configuration.DAY_VIEW)
			return;

		if (getCurrentViewMode() == Configuration.WEEK_VIEW) {
			WeekView weekView = (WeekView) mCurrentPanel.getCurrentView();
			weekView.setDayView(0, true);
		} else {
			ExtendedCalendar calendar = getCurrentCalendar();
			int col = calendar.getDayNumberOfWeek()-1;

			showPanel(Configuration.WEEK_VIEW, calendar, false);

			WeekView weekView = (WeekView) mCurrentPanel.getCurrentView();
			weekView.setDayView(col, false);
		}
	}

	public void setAgendaView(boolean search) {
		ExtendedCalendar calendar = getCurrentCalendar();

		if (getCurrentViewMode() == Configuration.AGENDA_VIEW) {
			mAgendaController.setCalendar(calendar, search);
			return;
		}

		LayoutInflater inflater = getLayoutInflater();
		mPanelAgenda = inflater.inflate(R.layout.panel_agenda, mMainLayout, false);

		mMainLayout.addView(mPanelAgenda);
		if (mCurrentPanel != null) {
			mCurrentPanel.onPause();
			mMainLayout.removeView(mCurrentPanel);
			mCurrentPanel = null;
		}

		mAgendaController = new AgendaController(this, mPanelAgenda);
		mAgendaController.setListener(this);
		mPanelHeader.setVisibility(View.GONE);

		mAgendaController.setCalendar(calendar, search);
	}

	private int getCurrentViewMode() {
		if (mCurrentPanel != null) {
			return ((PanelView)mCurrentPanel.getCurrentView()).getViewMode();
		} else if (mPanelAgenda != null){
			return Configuration.AGENDA_VIEW;
		}

		return -1;
	}

	private void gotoToday() {
		ExtendedCalendar today = ExtendedCalendar.getInstance();
		ExtendedCalendar cal = getCurrentCalendar();
		PanelView panel;

		switch (getCurrentViewMode()) {
		case Configuration.YEAR_VIEW:
			if (today.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
				return;
			panel = (PanelView) mCurrentPanel.getNextView();
			panel.setCalendar(today);
			mCurrentPanel.startSwitchViewAnimation(today.getTimeInMillis() > cal.getTimeInMillis());
			break;
		case Configuration.MONTH_VIEW:
			if (today.get(Calendar.MONTH) == cal.get(Calendar.MONTH) && today.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
				return;
			panel = (PanelView) mCurrentPanel.getNextView();
			panel.setCalendar(today);
			mCurrentPanel.startSwitchViewAnimation(today.getTimeInMillis() > cal.getTimeInMillis());
			break;
		case Configuration.WEEK_VIEW:
			if (today.get(Calendar.WEEK_OF_YEAR) == cal.get(Calendar.WEEK_OF_YEAR) && today.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
				return;
			panel = (PanelView) mCurrentPanel.getNextView();
			panel.setCalendar(today);
			mCurrentPanel.startSwitchViewAnimation(today.getTimeInMillis() > cal.getTimeInMillis());
			break;
		case Configuration.DAY_VIEW:
			if (today.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR) && today.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
				return;
			panel = (PanelView) mCurrentPanel.getNextView();
			panel.setCalendar(today);
			today = ExtendedCalendar.getInstance();
			WeekView weekView = (WeekView) mCurrentPanel.getNextView();
			weekView.setDayColumn(today.getDayNumberOfWeek()-1);
			mCurrentPanel.startSwitchViewAnimation(today.getTimeInMillis() > cal.getTimeInMillis());
			break;
		case Configuration.AGENDA_VIEW:
			mAgendaController.setCalendar(today, false);
			break;
		}
	}



	@Override
	public void doChangeView(int viewType, long time, Point point) {
		mCalendarTime = time;
		mAnimateNextViewChange = true;
		setNavigationToView(viewType);
	}

	private void setNavigationToView(int viewType) {
		switch (viewType) {
		case Configuration.YEAR_VIEW:
			mActionBar.setSelectedNavigationItem(0);
			break;
		case Configuration.MONTH_VIEW:
			mActionBar.setSelectedNavigationItem(1);
			break;
		case Configuration.WEEK_VIEW:
			mActionBar.setSelectedNavigationItem(2);
			break;
		case Configuration.DAY_VIEW:
			mActionBar.setSelectedNavigationItem(3);
			break;
		case Configuration.AGENDA_VIEW:
			mActionBar.setSelectedNavigationItem(4);
			break;
		}
	}

	@Override
	protected void onDestroy() {
		if (mAdView != null) {
			mAdView.destroy();
		}

		if (mCurrentPanel != null)
			mCurrentPanel.onPause();
		if (mAgendaController != null)
			mAgendaController.onDestroy();

		BitmapAllocator.getInstance().stopDebugThread();

		PreferenceHandler.setLastUsedView(this, getCurrentViewMode());

		if (mCurrentPanel != null) {
			mMainLayout.removeView(mCurrentPanel);
			mCurrentPanel = null;
		}
		if (mAgendaController != null) {
			mMainLayout.removeView(mPanelAgenda);
			mPanelAgenda = null;
			mAgendaController = null;
		}

		super.onDestroy();
	}

	@Override
	public void onCloseCalendarDialog(boolean eventsUpdated) {
		closeCalendarDialog(eventsUpdated);
	}

	private void showCalendarDialog(int layout, BaseEvent event) {
		if (mCalendarDialog != null) {
			return;
		}

		LayoutInflater inflater = getLayoutInflater();
		mCalendarDialog = (CalendarDialog)inflater.inflate(layout, mMainLayout, false);

		if (!PreferenceHandler.getHardwareAccelerationEnabled(this)) {
			mCalendarDialog.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			if (Configuration.LOG_DEBUG) {
				Log.d(LOG_TAG, "Disabled hardware acceleration for CalendarDialog");
			}
		}

		mCalendarDialog.setVisibility(View.VISIBLE);
		DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
		if (getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
			mCalendarDialog.setPadding(metrics.widthPixels/10, metrics.heightPixels/8, metrics.widthPixels/10, metrics.heightPixels/8);
		} else {
			mCalendarDialog.setPadding(metrics.widthPixels/6, metrics.heightPixels/20, metrics.widthPixels/6, metrics.heightPixels/20);
		}

		mMainLayout.addView(mCalendarDialog);
		mCalendarDialog.setOnCloseListener(this);

		mCalendarDialog.setAlpha(0);
		mCalendarDialog.setScaleX(0);
		mCalendarDialog.setScaleY(0);
		mCalendarDialog.query();
		mCalendarDialog.setEvent(event);

		mEventContentObserver.onPause();

		mActionMode = startActionMode(mCalendarDialog);
	}

	public void closeCalendarDialog(boolean update) {
		if (mCalendarDialog == null)
			return;

		if (update) {
			reQueryCurrentView();
		}

		if (mCurrentPanel != null) {
			((PanelView)mCurrentPanel.getCurrentView()).clearSelection();
		}

		mCalendarDialog.animate().cancel();
		mCalendarDialog.animate().setListener(new AnimatorListener() {

			private CalendarDialog mDialog;

			@Override
			public void onAnimationStart(Animator animation) {
				mDialog = mCalendarDialog;
				mCalendarDialog = null;
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				mMainLayout.removeView(mDialog);
				mDialog.setOnCloseListener(null);
				mDialog.closeView();
				mDialog = null;
				if (mActionMode != null) {
					mActionMode.finish();
					mActionMode = null;
				}
				mEventContentObserver.onResume();
			}

			@Override
			public void onAnimationCancel(Animator animation) {
			}
		});

		mCalendarDialog.animate().alpha(0);
		mCalendarDialog.animate().scaleX(0);
		mCalendarDialog.animate().scaleY(0);
		mCalendarDialog.animate().setDuration(Configuration.ANIMATION_DURATION_CALENDAR_DIALOG);
	}

	private void reQueryCurrentView() {
		if (mCurrentPanel != null) {
			((PanelView)mCurrentPanel.getCurrentView()).reQuery();
			((PanelView)mCurrentPanel.getNextView()).reQuery();
		} else if (mAgendaController != null) {
			mAgendaController.reQuery();
		}
	}

	private void syncCalendars() {
        Account[] accounts = AccountManager.get(this).getAccounts();

        String authority = Calendars.CONTENT_URI.getAuthority();
        for (int i = 0; i < accounts.length; i++) {
            if (Configuration.LOG_DEBUG)
            	Log.d(Configuration.LOG_TAG, "Requesting sync for: " + accounts[i]);

            Bundle extras = new Bundle();
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
            ContentResolver.requestSync(accounts[i], authority, extras);
        }
    }

	@Override
	public void onLicenseDenied() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
				builder.setTitle(R.string.licencemissingtitle);
				builder.setMessage(R.string.licencemissingmessage);
				builder.setCancelable(false);

			    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});

			    Dialog dialog = builder.create();
			    dialog.show();
			}
		});
	}

	@Override
	public void onLicenseAccepted() {
		if (mMainLayout != null) {
			if (mAdView != null) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						mMainLayout.removeView(mAdView);
						mAdView.pause();
						mAdView = null;
					}

				});
			}
		}
	}
}



*/