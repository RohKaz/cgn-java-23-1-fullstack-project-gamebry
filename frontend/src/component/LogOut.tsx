import axios from "axios";
import {useNavigate} from "react-router-dom";


export default function LogOut() {
    const navigate = useNavigate();

    return (
        axios.post("/api/users/logout").then(() => {
                navigate("/sign-in");
            }
        ))
}