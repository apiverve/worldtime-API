World Time API
============

World Time is a simple tool for getting the current time in any city. It returns the current time, date, and more.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Javascript Wrapper for the [World Time API](https://apiverve.com/marketplace/api/worldtime)

---

## Installation
	npm install @apiverve/worldtime --save

---

## Configuration

Before using the worldtime API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The World Time API documentation is found here: [https://docs.apiverve.com/api/worldtime](https://docs.apiverve.com/api/worldtime).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
var worldtimeAPI = require('@apiverve/worldtime');
var api = new worldtimeAPI({
    api_key: [YOUR_API_KEY],
    secure: true //(Optional, defaults to true)
});
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
var query = {
  city: "San Francisco"
};
```

###### Simple Request (using Callback)

```
api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "search": "San Francisco",
    "foundCities": [
      {
        "city": "San Francisco",
        "city_ascii": "San Francisco",
        "country": "Argentina",
        "iso2": "AR",
        "iso3": "ARG",
        "province": "Córdoba",
        "timezone": "America/Argentina/Cordoba",
        "time": "00:35",
        "time24": "00:35:06",
        "time12": "12:35:06 AM",
        "date": "2024-05-13",
        "day": "Monday",
        "month": "May",
        "year": "2024",
        "unix": "1715571306",
        "dst": false,
        "dst_start": "2024-05-13 00:35:06",
        "dst_end": "2024-05-13 00:35:06",
        "dst_name": "-03"
      },
      {
        "city": "San Francisco",
        "city_ascii": "San Francisco",
        "country": "United States of America",
        "iso2": "US",
        "iso3": "USA",
        "province": "California",
        "state_ansi": "CA",
        "timezone": "America/Los_Angeles",
        "time": "20:35",
        "time24": "20:35:06",
        "time12": "08:35:06 PM",
        "date": "2024-05-12",
        "day": "Sunday",
        "month": "May",
        "year": "2024",
        "unix": "1715571306",
        "dst": true,
        "dst_start": "2024-05-12 20:35:06",
        "dst_end": "2024-05-12 20:35:06",
        "dst_name": "PDT"
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2024 APIVerve, and Evlar LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.