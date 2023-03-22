import {Game} from "../model/Game";
import "./GameCard.css"


type GameCardProps = {
    game: Game;
}

export default function GameCard(props: GameCardProps) {
    return (
        <div className={"game-card"}>
            <h1>{props.game.gameTitle}</h1>
            <p>{props.game.gameDescription}</p>
        </div>
    )
}