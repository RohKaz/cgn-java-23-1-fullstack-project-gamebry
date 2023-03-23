import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import {CardActionArea} from '@mui/material';
import {Game} from "../model/Game";
import "./GameCard.css"

type GameCardProps = {
    game: Game;
}

export default function GameCard(props: GameCardProps) {

    return (
        <Card sx={{
            width: 250,
            height: 250,
            padding: 2,
            margin: 4,
            border: 2,
            borderColor: "black",
            borderRadius: 4,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            textAlign: "center",
            backgroundImage: ""

        }}>

            <CardActionArea>
                <CardMedia
                    component="img"
                    height="80"
                    width="80"
                    image=""
                    alt="Here should be a cover image of the game"
                />
                <CardContent>
                    <Typography
                        gutterBottom variant="h5"
                        component="div"
                        sx={{
                            alignContent: "bottom",
                            textAlign: "left",
                        }

                        }>

                        <p>
                            {props.game.gameTitle}
                        </p>

                    </Typography>
                    <Typography variant="body2" color="text.secondary">

                    </Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
}