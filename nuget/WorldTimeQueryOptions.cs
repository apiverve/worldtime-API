using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.WorldTime
{
    /// <summary>
    /// Query options for the World Time API
    /// </summary>
    public class WorldTimeQueryOptions
    {
        /// <summary>
        /// The city name for which you want to get the current time (e.g., New York)
        /// Example: San Francisco
        /// </summary>
        [JsonProperty("city")]
        public string City { get; set; }
    }
}
