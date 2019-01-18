# Task

Create a web application that show posts from reddit.com/r/programming. For simplicity, this data is already prepared in a local database.

#### Tech

A Spring Boot application with JPA and Derby file database is set up for you. Start the server and access at [http://localhost:8080](). 

A React skeleton has been created at `src/main/js/posts/index.jsx`.

Install npm and run `npm install` to fetch all required javascript dependencies.

Install webpack and run `webpack --watch` to rebuild the source files in `src/main/js/posts/` to a bundle in `src/main/resources/static/posts.js`.

#### Requirements

1. Show the posts in a data table.

1. Add a feature to select a post from the table and mark it as a favourite so we can review these posts at a later date.

1. A developer from another team wants to keep track of favourites in another module. 
   They're listening for an event in `TrackFavouritesService`. 
   Publish a `FavouriteAddedEvent` from your service using Spring's `ApplicationEventPublisher` and finish off their 
   service to keep a count of every favourite added. The developer mentioned previous problems persisting data from 
   `TrackFavouritesService`. 

#### Assumptions

1. Persisting Favourites is not required.

Added webpack-dev-server to help reactjs development, npm run start


   
