import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import {CardActionArea, Link, Tooltip, Zoom} from '@mui/material';
import {Game} from "../model/Game";

type GameCardProps = {
    game: Game;
}

export default function GameCard(props: GameCardProps) {

    return (
        <Link href={"/games/" + props.game.gameId} sx={{textDecoration: "none"}}>
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
                backgroundColor: "#545658",
                textDecoration: "none"
            }}
            >
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
                            <Tooltip TransitionComponent={Zoom} title={"Go to " + props.game.gameTitle} followCursor={true}>
                                <Link href={"/games/" + props.game.gameId}
                                      sx={{
                                          color: "black",
                                          fontWeight: "bold",
                                          textDecoration: "none",
                                      }}>{props.game.gameTitle}</Link>
                            </Tooltip>
                        </Typography>
                    </CardContent>
                </CardActionArea>
            </Card>
        </Link>
    );
}