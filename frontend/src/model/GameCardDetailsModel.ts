import {Genre} from "./Genre";
import {Publisher} from "./Publisher";
import {Platform} from "./Platform";

export type GameCardDetailsModel = {
    id: number;
    title: string;
    description: string;
    releaseDate: string;
    publishers: Publisher[];
    genres: Genre[];
    cover: string;
    rating: number;
    platforms: Platform[];

}