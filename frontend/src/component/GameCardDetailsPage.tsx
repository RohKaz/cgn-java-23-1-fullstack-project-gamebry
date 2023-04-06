import {useEffect, useState} from "react";
import {GameCardDetailsModel} from "../model/GameCardDetailsModel";
import {useParams} from "react-router-dom";
import axios from "axios";
import {Box, Collapse, Divider, List, ListItemButton, ListItemIcon, ListItemText} from "@mui/material";
import Typography from "@mui/material/Typography";
import AccessTime from "@mui/icons-material/AccessTime";
import {Category, ExpandLess, ExpandMore, Info, SportsEsports, SupervisedUserCircle} from "@mui/icons-material";


export default function GameCardDetailsPage() {

    const params = useParams();
    const id: string | undefined = params.id;

    const [details, setDetails] = useState<GameCardDetailsModel | undefined>();
    const [open, setOpen] = useState(true);
    const handleClick = () => {
        setOpen(!open);
    }

    const requestURL: string = "/api/games/" + id

    useEffect(() => {
        axios
            .get(requestURL)
            .then((response) => {
                setDetails(response.data);
                console.log(details);
            }).catch((error) => console.error(error));
    }, []);

    if (!details) {
        return <h1>NO DATA</h1>;
    }

    const genre = details.genres.map((genre) => {
        return (
            <ListItemText key={genre.id} primary={" " + genre.name + ","}/>
        )
    });

    const publisher = details.publishers.map((publisher) => {
        return (
            <ListItemText key={publisher.id} primary={" " + publisher.name + ","}/>
        )
    });

    return (
        <Box sx={{
            display: "flex",
            flexDirection: "",
            height: "auto",
            justifyContent: "left",
            textAlign: "left",
            padding: 6,
            backgroundColor: "#1f345c",
        }}>
            <Typography sx={{
                fontSize: 25,
                color: "white",
                textAlign: "left",
            }}>
                <div className={"game-title"}>{details.title}</div>
                <Box component="img" sx={{
                    imageRendering: "pixelated",
                    height: 250,
                    width: 220,
                    display: "flex",
                    marginTop: 2,
                }}
                     alt={"Here should be a cover image of the game"}
                     src={details.cover}
                />
                <List sx={{maxWidth: 400, height: "auto", color: "black", marginTop: 2,}}
                      component={"nav"}>
                    <ListItemButton onClick={handleClick}>
                        <ListItemIcon>
                            <Info/>
                        </ListItemIcon>
                        <ListItemText primary={"Game information"}/>
                        {open ? <ExpandLess/> : <ExpandMore/>}
                    </ListItemButton>
                    <Divider/>
                    <Collapse in={open} timeout={"auto"} unmountOnExit>
                        <List component={"div"} disablePadding>
                            <ListItemButton>
                                <ListItemIcon>
                                    <AccessTime/>
                                </ListItemIcon>
                                <ListItemText primary={"Release date: " + details.releaseDate}/>
                            </ListItemButton>
                            <ListItemButton>
                                <ListItemIcon>
                                    <SupervisedUserCircle/>
                                </ListItemIcon>
                                <ListItemText primary={"Publisher: "}/>
                                {publisher}
                            </ListItemButton>
                            <ListItemButton>
                                <ListItemIcon>
                                    <SportsEsports/>
                                </ListItemIcon>
                                <ListItemText primary={"Platforms: "}/>
                            </ListItemButton>
                            <ListItemButton>
                                <ListItemIcon>
                                    <Category/>
                                </ListItemIcon>
                                <ListItemText primary={"Genres: "}/>
                                {genre}
                            </ListItemButton>
                        </List>
                    </Collapse>
                </List>
                <Typography sx={{fontWeight: "bold", fontSize: 14, marginTop: 2}}>
                    About the game:
                </Typography>
                <Divider orientation={"horizontal"} sx={{border: 1, borderStyle: "", color: "black"}}/>
                <Typography sx={{fontSize: 10, color: "white", fontWeight: "bold", textAlign: "start",}}>
                    {details.description}
                </Typography>
            </Typography>
        </Box>
    )
}
