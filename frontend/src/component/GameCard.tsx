import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import {CardActionArea} from '@mui/material';
import {Game} from "../model/Game";

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
            border: 3,
            borderColor: "black",
            borderRadius: 6,
            display: "flex",
            flexDirection: "column",
            alignContent: "end",
            alignItems: "end",
            textAlign: "center",
            backgroundImage: "",
            backgroundColor: "#545658"
        }}>
            <CardActionArea sx={{
                height: "100%",
                display: "flex",
                flexDirection: "column",
            }}>
                <CardMedia
                    component="img"
                    image=""
                    alt="Here should be a cover image of the game"
                />
                <CardContent>
                    <Typography
                        component="div"
                        sx={{
                            mt: 20,
                            textAlign: "left",
                            fontSize: 15,
                            fontWeight: "bold",
                        }}>
                        {props.game.gameTitle}
                    </Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
}