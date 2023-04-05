import {Genre} from "./Genre";

export type GameCardModel = {
    id: number;
    title: string;
    releaseDate: string;
    genres: Genre[];
    cover: string;
    rating: number

}