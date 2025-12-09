declare module '@apiverve/worldtime' {
  export interface worldtimeOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface worldtimeResponse {
    status: string;
    error: string | null;
    data: WorldTimeData;
    code?: number;
  }


  interface WorldTimeData {
      search:      string;
      foundCities: FoundCity[];
  }
  
  interface FoundCity {
      city:       string;
      cityASCII:  string;
      country:    string;
      iso2:       string;
      iso3:       string;
      province:   string;
      timezone:   string;
      time:       string;
      time24:     string;
      time12:     string;
      date:       Date;
      day:        string;
      month:      string;
      year:       string;
      unix:       string;
      dst:        boolean;
      dstStart:   Date;
      dstEnd:     Date;
      dstName:    string;
      stateANSI?: string;
  }

  export default class worldtimeWrapper {
    constructor(options: worldtimeOptions);

    execute(callback: (error: any, data: worldtimeResponse | null) => void): Promise<worldtimeResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: worldtimeResponse | null) => void): Promise<worldtimeResponse>;
    execute(query?: Record<string, any>): Promise<worldtimeResponse>;
  }
}
