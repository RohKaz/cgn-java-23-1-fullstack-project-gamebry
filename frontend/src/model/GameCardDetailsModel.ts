import {Genre} from "./Genre";

export type GameCardDetailsModel = {
    id: number;
    name: string;
    released: string;
    background_image: string;
    metacritic: string;
    genres: Genre[];

}