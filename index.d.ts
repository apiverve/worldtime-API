declare module '@apiverve/worldtime' {
  export interface worldtimeOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface worldtimeResponse {
    status: string;
    error: string | null;
    data: any;
    code?: number;
  }

  export default class worldtimeWrapper {
    constructor(options: worldtimeOptions);

    execute(callback: (error: any, data: worldtimeResponse | null) => void): Promise<worldtimeResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: worldtimeResponse | null) => void): Promise<worldtimeResponse>;
    execute(query?: Record<string, any>): Promise<worldtimeResponse>;
  }
}
