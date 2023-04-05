import {Genre} from "./Genre";
import {Publisher} from "./Publisher";

export type GameCardDetailsModel = {
    id: number;
    title: string;
    description: string;
    releaseDate: string;
    publishers: Publisher[];
    genres: Genre[];
    cover: string;
    rating: number

}