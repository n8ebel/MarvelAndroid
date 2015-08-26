## MarvelDroid
Android library to work with the [Marvel Comics Api](http://developer.marvel.com/).
Make sure to check out the documentation provided by Marvel, especially the [Attribution Info](http://developer.marvel.com/).

### Recent Updates
8/26/15 - Beta 1 will be released very soon.  This release will contain functional endpoints to retreive all entity types.  Method names and class structure might still change however.


This project is currently under development.

- [x] Character endpoint
- [x] Comic
- [x] Creator
- [x] Event
- [x] Series
- [x] Stories

Supports two patterns of network calls:
- Asynchronous callback
- RxJava observables

Entities (Comics, Characters, etc..) are retrieved through an `Endpoint` class.  
For example, `ComicEndpoint` provides methods for retrieving comics in various ways across each of the rest endpoints.  

ex:
- `comicEndpoint.getComicForId(comicId)`
- `comicEndpoint.getComicsForCharacterId(characterId, comicQueryParams)`

 
## Example Usage

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
