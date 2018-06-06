
Finally the AppBajarLib is at Github.

Save 50% coding time using common and simple methods of AppBajarLib.
Nothing is new here, we just tried to combine 3 to 10 lines code into single line to save the development time and faster the overall progress.
We will continue our effort and have plan to make this library as official SDK of AppBajar (https://appbajar.com) marketplace for in app purchase/subscription/ad network features .

**HOW TO USE:-


Add following line into build.gradle file and sync.


buildscript {

    // following lines/block is important for AppBajar Library
    
    repositories {
        mavenCentral()
    }

}


compile 'com.aapbd:appbajar-lib:1.0.2'


**Example:-
**




To make Activity full screen, just call
DisplayUtils.fullScreen(youractivityname);


To open keyboard, call
KeyBoardManager.openKeyBoard(Context con, final View v);


To remember login/logout state and save logged user info,
PersistentUser.getInstance().setLogin(Context c);


**Youtube Channel for tutorial series:
**



https://www.youtube.com/channel/UCACWA2yNIGZe7SxiTWBAW4Q

NOTHING IS NEW BUT EVERYTHING IS REDEFINED. It's an output of 6 years work!
