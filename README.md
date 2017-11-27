# udacity-score
Udacity Android Basic course. Project 2: Basketball tracker.



I decided to stick to the basketball, mainly because I wanted to add some extra and challenging (for me) functionality. How many buttons on the screen and what they are tracking - not so important. Or so I thought. 

I had few goals in mind:

1) Propper version control with Git and Github. So I made a "detour" and took course ["How to Use Git and GitHub"](https://www.udacity.com/course/how-to-use-git-and-github--ud775). I highly recommend it to everyone! Git allows you to make wild things during development. Like, allow a cat to sleep on your keyboard without risk of losing everything! Shocking, huh?! Seriously - just learn it, use it and love it. You will need it later anyway.

2) "Undo" button. The user should be able to cancel at least the last action. Ideally - all of them, but I decided to keep it simple for now. 

3) Editable teams names - I never saw the game between the "Team A" and the "Team B" in "real life" :(. 

3) "Reset" button. Button, which, well, reset everything, including team names (but keeps them in case the user wants to use them again).

4) Ability to keep everything (including a possibility to undo the last action) during screen rotation.

5) Nice and "clickable" buttons. Not just pictures. 

6) Proper commenting and using best practices like storing texts in strings, using styles, etc.

The design wasn't important to me this time. I decided to make it readable, clean and straightforward, not exceptional or outstanding.

Any shortcomings? Yep! I decided to use a workaround for saving a state of teams names during screen rotation - via "android:freezesText". And did NOT use the ScrolView - this one messed up with the buttons on the bottom of the screen. I may address this later, with more skills and knowledge. 

Full-size screenshots [in Dropbox](https://www.dropbox.com/sh/7e9f7d78q2h4f07/AAColOJztUwTDykAfagiL6gCa?dl=0).
