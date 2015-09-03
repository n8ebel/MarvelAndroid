## MarvelDroid
Android library to work with the [Marvel Comics Api](http://developer.marvel.com/).
Make sure to check out the documentation provided by Marvel, especially the [Attribution Info](http://developer.marvel.com/).

### Recent Updates
9/1/15 - [Beta 1](https://github.com/n8ebel/Marvel_Android/releases/tag/v0.9) is ready to go!!  Please try it out, create issues for anything you find that isn't working correctly.  I will continue building out samples and have a couple additional enhancements on the way.

8/28/15 - Offical Beta 1 will be out by the end of the month.  These is now a very basic sample project included in the repo to help get you started playing with the apis.

8/26/15 - Beta 1 will be released very soon.  This release will contain functional endpoints to retreive all entity types.  Method names and class structure might still change however.


This project is currently under development.

Entities (Comics, Characters, etc..) are retrieved through an `Endpoint` class.  
For example, `ComicEndpoint` provides methods for retrieving comics in various ways across each of the rest endpoints.  

ex:
- `comicEndpoint.getComicForId(comicId)`
- `comicEndpoint.getComicsForCharacterId(characterId, comicQueryParams)`

Supports two patterns of network calls:
- Asynchronous callback
- RxJava observables

Implemented endpoints
- [x] Character endpoint
- [x] Comic
- [x] Creator
- [x] Event
- [x] Series
- [x] Stories


## Sample Project
There is a sample project included with the repo.  Clone or download the repo to build and run the sample and start playing with the apis.

To run the sample, **you will need your own api keys from Marvel**.  You can get keys by going [here](http://developer.marvel.com/), registering an account, and then copying those into your project.
 
## Example Usages

### Characters
```
MarvelAndroid.initialize(context, "YOUR_PRIVATE_KEY", "YOUR_PUBLIC_KEY", cache_size);
CharacterEndpoint characterEndpoint = MarvelAndroid.getInstance().getCharacterEndpoint();

CharacterQueryParams queryParams = new CharacterQueryParams();
queryParams.setNameStartsWith("spider");

// Callback
characterEndpoint.getCharacters(queryParams, new Callback<ServiceResponse<Character>>() {
            @Override
            public void success(ServiceResponse<Character> characterServiceResponse, Response response) {
                
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        
// RxJava Observable
Observable<ServiceResponse<Character>> observable = characterEndpoint.getCharacters(queryParams);
```

### Comics
```
ComicQueryParams queryParams = new ComicQueryParams();
 queryParams.setOrderBy(ComicQueryParams.OrderBy.Title);

 MarvelAndroid marvelAndroid = MarvelAndroid.getInstance();
 ComicEndpoint comicEndpoint = marvelAndroid.getComicEndpoint();

 /*
  * Standard way
  */

// Retrieve list of comics through async callback
//
comicEndpoint.getComics(queryParams, new Callback<RequestResponse<Comic>>() {
    @Override
    public void success(RequestResponse<Comic> requestResponse, Response response) {
        List<Comic> comics = requestResponse.data.results;

        for (Comic comic : comics) {
            Log.d("foo", comic.title + " " + comic.description);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        mMsg += error.getLocalizedMessage() + "\n";
        textView.setText(mMsg);
    }
});

// Same results, but returned through RxJava Observable subscription
//
Observable<RequestResponse<Comic>> comics = comicEndpoint.getComics(queryParams);
comics.subscribe(new Action1<RequestResponse<Comic>>() {
    @Override
    public void call(RequestResponse<Comic> comicRequestResponse) {
        List<Comic> comics = requestResponse.data.results;

        for (Comic comic : comics) {
            Log.d("foo", comic.title + " " + comic.description);
        }
    }
});
```

## License
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
