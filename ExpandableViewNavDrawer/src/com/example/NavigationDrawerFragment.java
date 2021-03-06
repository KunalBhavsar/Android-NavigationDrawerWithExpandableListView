package com.example;



import java.lang.reflect.Field;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Fragment class for creating Navigation drawer.
 * @author Neebal Technologies
 * 
 */
public class NavigationDrawerFragment extends Fragment implements OnClickListener {
	
	/**
	 * Helper component that ties the action bar to the navigation drawer.
	 */
	private ActionBarDrawerToggle mDrawerToggle;
	/**
	 * Stores fragment UI.
	 */
	private DrawerLayout mDrawerLayout;
	/**
	 * Represent expandable list view of the items of navigation drawer
	 */
	private ExpandableListView myExpandableListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of
		// actions in the action bar.
		setHasOptionsMenu(true);
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View mDrawerRelativeLayout = (View) inflater.inflate(
				R.layout.fragment_navigation_drawer, container, false);

			
		return mDrawerRelativeLayout;
	}

	@SuppressLint("NewApi")
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		//Represent the expandable list view
		myExpandableListView = (ExpandableListView) view
				.findViewById(R.id.exp_my_groups);
		
		//set the adapter for showing list of items
		notifyDrawerAdapter();
	}
	//reset the navigation drawer (in case any new resource of request get out dated)
	public void notifyDrawerAdapter() {
		
		//for setting the manual group indicator remove the default one
		myExpandableListView.setGroupIndicator(null);
		
		//get the list of groups and its childs from key constants 
		String[] groupItems = {"A","B","C","D"};
		String[][] groupSubitems = {
				{"a","b","c","d"},{"a","b","c","d"},{},{"a","b","c","d"}};
		
		//Represent the expandable list adapter
		ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(groupItems,
				groupSubitems, true);
		//set the adapter on expandable list view
		myExpandableListView.setAdapter(expandableListAdapter);
		
		//set the click listener on child and groups
		myExpandableListView.setOnChildClickListener(myGroupItemClicked);
		myExpandableListView.setOnGroupClickListener(myGroupClicked);
	}

	/**
	 * Child click listener for expandable list view
	 */
	private OnChildClickListener myGroupItemClicked = new OnChildClickListener() {

		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			if(groupPosition == 0) { //A
				if (childPosition == 0) { // a
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected A => a group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 1) { // b
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected A => b group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 2) {// c
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected A => c group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 3) {// d
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected A => d group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
			}
			else if(groupPosition == 1) { // B
				if (childPosition == 0) { // a
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected B => a group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 1) { // b
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected B => b group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 2) {// c
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected B => c group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 3) {// d
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected B => d group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
			}
			else if(groupPosition == 2) { // C
				//here we dont have any child
			}
			else if(groupPosition == 3) { // D
				if (childPosition == 0) { // a
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected D => a group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 1) { // b
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected D => b group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 2) {// c
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected D => c group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
				else if (childPosition == 3) {// d
					//else just close the drawer
					Toast.makeText(getActivity().getApplicationContext(), "U selected D => d group", Toast.LENGTH_SHORT).show();
					mDrawerLayout.closeDrawers();
				}
			}
			return false;
		}

	};
	
	/**
	 * group click listener for expandable list view
	 */
	private OnGroupClickListener myGroupClicked = new OnGroupClickListener() {
		
		@Override
		public boolean onGroupClick(ExpandableListView parent, View v,
				int groupPosition, long id) {
			if(groupPosition == 0) { //A
				//TODO: action on group A click
			}
			else if(groupPosition == 1) { //B
				//TODO: action on group B click
			}
			else if(groupPosition == 2) { //C
				Toast.makeText(getActivity().getApplicationContext(), "U selected C group", Toast.LENGTH_SHORT).show();
				mDrawerLayout.closeDrawers();
			}
			else if(groupPosition == 3) { //D
				//TODO: action on group D click
			}
			
			return false;
		}
	};
	/**
	 * This class holds the views required for the Expandable list adapter
	 * @author Neebal Technologies
	 */
	class MyExpandableItemsViewHolder {
		private TextView text;
		private ImageView expIcon;
	}
	/**
	 * Expandable list adapter for showing expanded sublist on clicking main
	 * list item.
	 * @author Neebal Technologies
	 */
	public class ExpandableListAdapter extends BaseExpandableListAdapter {

		private final LayoutInflater inf;
		private String[] groups;
		private String[][] children;
		
		public ExpandableListAdapter(String[] groups, String[][] children,boolean isMyCalendar) {
			this.groups = groups;
			this.children = children;
			inf = LayoutInflater.from(getActivity());
		}

		@Override
		public int getGroupCount() {
			return groups.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return children[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}
		
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return children[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			
			View view = inf.inflate(R.layout.list_nav_item, parent, false);
				
			//get the views from view holder
			MyExpandableItemsViewHolder myExpandableItemsViewHolder = new MyExpandableItemsViewHolder();
			
			myExpandableItemsViewHolder.text = (TextView) view.findViewById(R.id.txt_list_item);
			
			//get the string child view text and set it on text view
			String itemText = getChild(groupPosition, childPosition).toString();
			myExpandableItemsViewHolder.text.setText(itemText);
			
			//set the top divider of 1st child of each group as invisible
			if(childPosition == 0) {
				((View) view.findViewById(R.id.item_devider_of_navigation_drawer)).setVisibility(View.INVISIBLE);
			}
			return view;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			
			convertView = inf.inflate(R.layout.list_nav_group, parent, false);
			
			//get the views from view holder class
			MyExpandableItemsViewHolder myExpandableItemsViewHolder = new MyExpandableItemsViewHolder();
			myExpandableItemsViewHolder.expIcon = (ImageView)convertView.findViewById(R.id.img_exp_icon);
			
			myExpandableItemsViewHolder.text = (TextView) convertView.findViewById(R.id.txt_list_header);
			//set the text from string passed to group view
			myExpandableItemsViewHolder.text.setText(getGroup(groupPosition).toString());
			
			//if children count is 0 then set the drawable of expandable icon to null
			if(getChildrenCount(groupPosition) == 0) {
				myExpandableItemsViewHolder.expIcon.setImageDrawable(null);
			}
			else {
			//else set the open/close expandable icon
				if(isExpanded) {
					myExpandableItemsViewHolder.expIcon.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_action_collapse));
				}
				else {
					myExpandableItemsViewHolder.expIcon.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_action_expand));
				}
			}
			return convertView;
		}
		
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}
	
	/**
	 * Users of this fragment must call this method to set up the navigation
	 * drawer interactions.
	 * 
	 * @param fragmentId
	 *            The android:id of this fragment in its activity's layout.
	 * @param drawerLayout
	 *            The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
		
		mDrawerLayout = drawerLayout;
		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		
		//remove the app icon from action bar and set the navigation drawer button
		ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
	    actionBar.setDisplayShowTitleEnabled(true);
	    
		// ActionBarDrawerToggle ties together the the proper interactions
		// between the navigation drawer and the action bar app icon.
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(),// host Activity
				mDrawerLayout,// DrawerLayout object
				R.drawable.ic_drawer, // nav drawer image to replace 'Up' caret
				R.string.navigation_drawer_open,// "open drawer" description for accessibility
				R.string.navigation_drawer_close // "close drawer" description for accessibility
		) {
			@Override
			public void onDrawerClosed(View drawerView) {
				//called when drawer is closed
				super.onDrawerClosed(drawerView);
				if (!isAdded()) {
					return;
				}
				
				//set the action bar
				ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
				actionBar.setHomeButtonEnabled(true);
			    actionBar.setDisplayHomeAsUpEnabled(true);
			    actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
			    actionBar.setDisplayShowTitleEnabled(true);

				getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				//called when drawer is opened
				super.onDrawerOpened(drawerView);
				if (!isAdded()) {
					return;
				}
				InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus()
										.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
				
				//set the action bar
				ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
				actionBar.setHomeButtonEnabled(true);
			    actionBar.setDisplayHomeAsUpEnabled(true);
			    actionBar.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
			    actionBar.setDisplayShowTitleEnabled(false);
			    
			    getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}
		};
		
		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
		getOverflowMenu();
	}
	
	private void getOverflowMenu() {

	     try {
	        ViewConfiguration config = ViewConfiguration.get(getActivity().getApplicationContext());
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	        if(menuKeyField != null) {
	            menuKeyField.setAccessible(true);
	            menuKeyField.setBoolean(config, false);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

	}

	@Override
	public void onDetach() {
		super.onDetach();

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onClick(View v) {
	}
	
}
