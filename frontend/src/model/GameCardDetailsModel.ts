import {Genre} from "./Genre";
import {Publisher} from "./Publisher";
import {Platform} from "./Platform";

export type GameCardDetailsModel = {
    description_raw: string;
    id: number;
    title: string;
    releaseDate: string;
    publishers: Publisher[];
    genres: Genre[];
    cover: string;
    rating: number;
    platforms: Platform[];

}