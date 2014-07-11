package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCSVFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXMLFile(new File ("groups.xml"))).iterator();
	}	
	

@Test(dataProvider =  "groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	
    //save old state
	 SortedListOf<GroupData> oldList = app.getModel().getGroups();
	 //SortedListOf<GroupData> oldList = app.getGroupHelper().getUIGroups();
    
    //actions
    app.getGroupHelper().createGroup(group);
    
    
    //save new state
    SortedListOf<GroupData> newList = app.getModel().getGroups();
    
    //compare states - correct modification of the model
    assertThat(newList, equalTo(oldList.withAdded(group)));
    
    if ("yes".equals(app.getProperty("check.db"))) {
    	if (wantToCheck()) {
    //compare model with data in DB
    assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
    	}
    }
    
    if ("yes".equals(app.getProperty("check.ui"))) {
    	if (wantToCheck()) {
    //compare model with UI data
    assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUIGroups()));
    	}
    }
   }
}
