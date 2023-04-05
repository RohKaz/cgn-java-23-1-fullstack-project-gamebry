import {Genre} from "./Genre";

export type GameCardModel = {
    id: number;
    name: string;
    released: string;
    background_image: string;
    metacritic: string
    genres: Genre[];
}