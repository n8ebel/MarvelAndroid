## MarvelDroid

Android library to work with the [Marvel Comics Api](http://developer.marvel.com/).

This project is currently under development.

- [x] Character endpoint
- [ ] Comic
- [ ] Creator
- [ ] Event
- [ ] Series
- [ ] Stories

I plan to support two patterns of network calls:

- Asynchronous callback
- RxJava observables
 
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
