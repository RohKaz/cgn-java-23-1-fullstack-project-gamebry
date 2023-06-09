import {useEffect, useState} from "react";
import {useLocation, useNavigate} from "react-router-dom";
import axios from "axios";


type User = {
    id: string;
    username: string;
    role: string;
}

export default function useAuth(redirectToSignIn?: boolean) {

    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [user, setUser] = useState<User | null>(null);
    const navigate = useNavigate();
    const {pathname} = useLocation();

    useEffect(() => {
        axios.get("/api/users/me").then((res) => {
            setUser(res.data);
        }).catch(e => {
            if (redirectToSignIn && e.response.status === 401) {
                window.sessionStorage.setItem("signInRedirect", pathname || "/");
                navigate("/sign-in");
            }
        });
    }, [pathname, navigate, redirectToSignIn]);
    return {user, username, password, setUsername, setPassword};
}