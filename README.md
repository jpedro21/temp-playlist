## Temp Playlist

This project is a microservice that return playlists by the localization informed by client.
To get the localization the Openweathermap.org/ is used and for get the playlist the Spotify api is used.

## Project Technology

* Spring boot
* Spring Cloud
* Eureka
* Hytrix
* Cache(for Openweathermap and Spotify calls)

##

## Business rules

* If temperature (celcius) is above 30 degrees, suggest tracks for party
* In case temperature is between 15 and 30 degrees, suggest pop music tracks
* If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks
* Otherwise, if it's freezing outside, suggests classical music tracks

### Setup

Unfortily setup by docker stills dosen't ready then the project order to start is:
1- the temp-playlist-config-server
2- temp-playlist-eureka-server
3- temp-playlist-search-temp-playlist
