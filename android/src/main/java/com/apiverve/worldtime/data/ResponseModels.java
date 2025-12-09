// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     WorldTimeData data = Converter.fromJsonString(jsonString);

package com.apiverve.worldtime.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static WorldTimeData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(WorldTimeData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(WorldTimeData.class);
        writer = mapper.writerFor(WorldTimeData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// WorldTimeData.java

package com.apiverve.worldtime.data;

import com.fasterxml.jackson.annotation.*;

public class WorldTimeData {
    private String search;
    private FoundCity[] foundCities;

    @JsonProperty("search")
    public String getSearch() { return search; }
    @JsonProperty("search")
    public void setSearch(String value) { this.search = value; }

    @JsonProperty("foundCities")
    public FoundCity[] getFoundCities() { return foundCities; }
    @JsonProperty("foundCities")
    public void setFoundCities(FoundCity[] value) { this.foundCities = value; }
}

// FoundCity.java

package com.apiverve.worldtime.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class FoundCity {
    private String city;
    private String cityASCII;
    private String country;
    private String iso2;
    private String iso3;
    private String province;
    private String timezone;
    private String time;
    private OffsetTime time24;
    private String time12;
    private LocalDate date;
    private String day;
    private String month;
    private String year;
    private String unix;
    private boolean dst;
    private OffsetDateTime dstStart;
    private OffsetDateTime dstEnd;
    private String dstName;
    private String stateANSI;

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("city_ascii")
    public String getCityASCII() { return cityASCII; }
    @JsonProperty("city_ascii")
    public void setCityASCII(String value) { this.cityASCII = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("iso2")
    public String getIso2() { return iso2; }
    @JsonProperty("iso2")
    public void setIso2(String value) { this.iso2 = value; }

    @JsonProperty("iso3")
    public String getIso3() { return iso3; }
    @JsonProperty("iso3")
    public void setIso3(String value) { this.iso3 = value; }

    @JsonProperty("province")
    public String getProvince() { return province; }
    @JsonProperty("province")
    public void setProvince(String value) { this.province = value; }

    @JsonProperty("timezone")
    public String getTimezone() { return timezone; }
    @JsonProperty("timezone")
    public void setTimezone(String value) { this.timezone = value; }

    @JsonProperty("time")
    public String getTime() { return time; }
    @JsonProperty("time")
    public void setTime(String value) { this.time = value; }

    @JsonProperty("time24")
    public OffsetTime getTime24() { return time24; }
    @JsonProperty("time24")
    public void setTime24(OffsetTime value) { this.time24 = value; }

    @JsonProperty("time12")
    public String getTime12() { return time12; }
    @JsonProperty("time12")
    public void setTime12(String value) { this.time12 = value; }

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("day")
    public String getDay() { return day; }
    @JsonProperty("day")
    public void setDay(String value) { this.day = value; }

    @JsonProperty("month")
    public String getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(String value) { this.month = value; }

    @JsonProperty("year")
    public String getYear() { return year; }
    @JsonProperty("year")
    public void setYear(String value) { this.year = value; }

    @JsonProperty("unix")
    public String getUnix() { return unix; }
    @JsonProperty("unix")
    public void setUnix(String value) { this.unix = value; }

    @JsonProperty("dst")
    public boolean getDst() { return dst; }
    @JsonProperty("dst")
    public void setDst(boolean value) { this.dst = value; }

    @JsonProperty("dst_start")
    public OffsetDateTime getDstStart() { return dstStart; }
    @JsonProperty("dst_start")
    public void setDstStart(OffsetDateTime value) { this.dstStart = value; }

    @JsonProperty("dst_end")
    public OffsetDateTime getDstEnd() { return dstEnd; }
    @JsonProperty("dst_end")
    public void setDstEnd(OffsetDateTime value) { this.dstEnd = value; }

    @JsonProperty("dst_name")
    public String getDstName() { return dstName; }
    @JsonProperty("dst_name")
    public void setDstName(String value) { this.dstName = value; }

    @JsonProperty("state_ansi")
    public String getStateANSI() { return stateANSI; }
    @JsonProperty("state_ansi")
    public void setStateANSI(String value) { this.stateANSI = value; }
}