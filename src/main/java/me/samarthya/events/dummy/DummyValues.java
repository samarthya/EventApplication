package me.samarthya.events.dummy;

import me.samarthya.events.model.EventsModel;
import me.samarthya.events.model.LocationModel;
import me.samarthya.events.model.SessionModel;
import me.samarthya.events.model.VotersModel;
import me.samarthya.events.jpa.repository.EventRepository;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Dummy value for the database constructor.
 */
public class DummyValues {

    public static void dummyDataCreator(EventRepository eventRepository) {
        Set<EventsModel> ems = new HashSet<>();
        Set<SessionModel> sm = new HashSet<>();
        Set<VotersModel> vm = new HashSet<>();


        /**
         * Adding the voters.
         */
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("martinfowler"));

        /**
         * New Session.
         */

        // Event 1
        sm.add(new SessionModel("Using Angular 4 Pipes", "Peter Bacon Darwin", 1, "Intermediate",
                "We all know that our dev teams work hard, but with" +
                        "  the right management they can be even more productive, without" +
                        "  overworking them. In this session I'll show you how to get the" +
                        "  best results from the talent you already have on staff.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("johnpapa"));
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("martinfowler"));


        sm.add(new SessionModel("Getting the most out of your dev team", "Jeff Cross", 1,
                "Intermediate",
                "Learn all about the new pipes in Angular 4, both" +
                        " how to write them, and how to get the new AI CLI to write" +
                        " them for you. Given by the famous PBD, president of Angular" +
                        " University (formerly Oxford University)", Collections.unmodifiableSet(vm)));


        vm.clear();


        sm.add(new SessionModel("Angular 4 Performance Metrics", "Rob Wormald", 2,
                "Advanced",
                "Even though Angular 5 is still 6 years away, we all want" +
                        " to know all about it so that we can spend endless hours in meetings" +
                        " debating if we should use Angular 4 or not. This talk will look at" +
                        " Angular 6 even though no code has yet been written for it. We'll" +
                        " look at what it might do, and how to convince your manager to" +
                        " hold off on any new apps until it's released", Collections.unmodifiableSet(vm)));

        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));


        sm.add(new SessionModel("Basics of Angular 4", "John Papa", 2,
                "Beginner",
                "It's time to learn the basics of Angular 4. This talk" +
                        " will give you everything you need to know about Angular 4 to" +
                        " get started with it today and be building UI's for your self" +
                        " driving cars and butler-bots in no time.", Collections.unmodifiableSet(vm)));

        ems.add(new EventsModel(
                "Angular Connect", new GregorianCalendar(2036 + 1900, 9, 20).getTime(),
                "10:00 AM", 599.99,
                "/assets/images/angularconnect-shield.png",
                null, new LocationModel("1057 DT", "London", "England"), Collections.unmodifiableSet(sm)));


        // Event 2
        sm.clear();

        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));

        sm.add(new SessionModel("Testing Angular 4 Workshop", "Pascal Precht & Christoph Bergdorf", 4,
                "Beginner",
                "In this 6 hour workshop you will learn not only how to test Angular 4," +
                        " you will also learn how to make the most of your team's efforts. Other topics" +
                        " will be convincing your manager that testing is a good idea, and using the new" +
                        " protractor tool for end to end testing.", Collections.unmodifiableSet(vm)));

        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("johnpapa"));

        sm.add(new SessionModel("Angular 4 and Firebase", "David East", 3,
                "Intermediate",
                "In this workshop, David East will show you how to use Angular with the new" +
                        "  ultra-real-time 5D Firebase back end, hosting platform, and wine recommendation engine.",
                Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("martinfowler"));

        sm.add(new SessionModel("Reading the Angular 4 Source", "Patrick Stapleton", 2,
                "Intermediate",
                "Angular 4's source code may be over 25 million lines of code, but it's really" +
                        " a lot easier to read and understand then you may think. Patrick Stapleton will talk" +
                        " about his secretes for keeping up with the changes, and navigating around the code.",
                Collections.unmodifiableSet(vm)));

        vm.clear();
        vm.add(new VotersModel("bradgreen"));

        sm.add(new SessionModel("Hail to the Lukas", "Lukas Ruebbelke", 1,
                "Beginner",
                "In this session, Lukas will present the" +
                        " secret to being awesome, and how he became the President" +
                        " of the United States through his amazing programming skills," +
                        " showing how you too can be success with just attitude.",
                Collections.unmodifiableSet(vm)));

        ems.add(new EventsModel("ng-nl", new GregorianCalendar(2037 + 1900, 4, 15).getTime(),
                "9:00 AM", 950.00,
                "/assets/images/ng-nl.png",
                null, new LocationModel("The NG-NL Convention Center & Scuba Shop",
                "Amsterdam", "Netherlands"),
                Collections.unmodifiableSet(sm)));

        // Event 3
        sm.clear();
        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("martinfowler"));
        vm.add(new VotersModel("igorminar"));

        sm.add(new SessionModel("How Elm Powers Angular 4", "Murphy Randle", 2,
                "Intermediate", "We all know that Angular is written in Elm, but did you know how the source code is really written? In this exciting look into the internals of Angular 4, we'll see exactly how Elm powers the framework, and what you can do to take advantage of this knowledge.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("martinfowler"));

        sm.add(new SessionModel("Angular and React together", "Jamison Dance", 2,
                "Intermediate", "React v449.6 has just been released. Let's see how to use this new version with Angular to create even more impressive applications.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("martinfowler"));
        vm.add(new VotersModel("johnpapa"));

        sm.add(new SessionModel("Redux Woes", "Rob Wormald", 1,
                "Intermediate",
                "Everyone is using Redux for everything from Angular to React to Excel macros, but you're still having trouble grasping it? We'll take a look at how farmers use Redux when harvesting grain as a great introduction to this game changing technology.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("martinfowler"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("johnpapa"));

        sm.add(new SessionModel("ng-wat again!!", "Shai Reznik", 1,
                "Beginner",
                "Let's take a look at some of the stranger pieces of Angular 4, including neural net nets, Android in Androids, and using pipes with actual pipes.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("martinfowler"));


        sm.add(new SessionModel("Dressed for Success", "Ward Bell", 2,
                "Beginner", "Being a developer in 2037 is about more than just writing bug-free code. You also have to look the part. In this amazing expose, Ward will talk you through how to pick out the right clothes to make your coworkers and boss not only respect you, but also want to be your buddy.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("johnpapa"));


        sm.add(new SessionModel("These aren't the directives you're looking for", "John Papa", 2,
                "Intermediate",
                "Coinciding with the release of Star Wars Episode 18, this talk will show how to use directives in your Angular 4 development while drawing lessons from the new movie, featuring all your favorite characters like Han Solo's ghost and Darth Jar Jar.", Collections.unmodifiableSet(vm)));

        ems.add(new EventsModel("ng-conf 2037", new GregorianCalendar(2037 + 1900, 5, 4).getTime(),
                "9:00 AM", 759.00,
                "/assets/images/ng-conf.png", null, new LocationModel("The Palatial America Hotel",
                "Salt Lake City", "USA"), Collections.unmodifiableSet(sm)));


        // Event 4
        sm.clear();
        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));

        sm.add(new SessionModel("Diversity in Tech", "US Secretary of State Zach Galifianakis", 2,
                "Beginner",
                "Yes, we all work with cyborgs and androids and Martians, but we probably don't realize that sometimes our internal biases can make it difficult for these well-designed coworkers to really feel at home coding alongside us. This talk will look at things we can do to recognize our biases and counteract them.", Collections.unmodifiableSet(vm)));

        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("johnpapa"));

        sm.add(new SessionModel("World Peace and Angular", "Sir Dave Smith", 2,
                "Beginner",
                "Angular has been used in most of the major peace brokering that has happened in the last decade, but there is still much we can do to remove all war from the world, and Angular will be a key part of that effort.", Collections.unmodifiableSet(vm)));

        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("johnpapa"));


        sm.add(new SessionModel("Using Angular with Androids", "Dan Wahlin", 3,
                "Advanced",
                "Androids may do everything for us now, allowing us to spend all day playing the latest Destiny DLC, but we can still improve the massages they give and the handmade brie they make using Angular 4. This session will show you how.", Collections.unmodifiableSet(vm)));


        ems.add(new EventsModel("UN Angular Summit",
                new GregorianCalendar(2037 + 1900, 6, 10).getTime(),
                "8:00 AM", 800.00,
                "/assets/images/basic-shield.png", null,
                new LocationModel("The UN Angular Center",
                        "New York", "USA"), Collections.unmodifiableSet(sm)));


        //Event 5
        sm.clear();
        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));

        sm.add(new SessionModel("Gambling with Angular", "John Papa", 1,
                "Intermediate",
                "No, this talk isn't about slot machines. We all know that Angular is used in most waiter-bots and coke vending machines, but did you know that was also used to write the core engine in the majority of voting machines? This talk will look at how all presidential elections are now determined by Angular code.", Collections.unmodifiableSet(vm)));


        vm.clear();
        vm.add(new VotersModel("bradgreen"));
        vm.add(new VotersModel("igorminar"));
        vm.add(new VotersModel("johnpapa"));

        sm.add(new SessionModel("Angular 4 in 60ish Minutes", "Dan Wahlin", 2,
                "Beginner",
                "Get the skinny on Angular 4 for anyone new to this great new technology. Dan Wahlin will show you how you can get started with Angular in 60ish minutes, guaranteed!", Collections.unmodifiableSet(vm)));


        ems.add(new EventsModel("ng-vegas",
                new GregorianCalendar(2037 + 1900, 10, 2).getTime(),
                "9:00 AM", 400.00,
                "/assets/images/ng-vegas.png", null,
                new LocationModel("The Excalibur",
                        "Las Vegas", "USA"), Collections.unmodifiableSet(sm)));

        eventRepository.saveAll(ems);

        ems.clear();
    }
}
