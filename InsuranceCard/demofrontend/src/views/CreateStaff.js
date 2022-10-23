import { useState } from "react";
import "../styles/createStaff.scss";
import {
  BsFillPersonFill,
  BsShieldLockFill,
  BsFillCalendarEventFill,
  BsFillTelephoneFill,
  BsEnvelopeFill,
  BsFillPeopleFill,
  BsGenderAmbiguous,
  BsGeoAltFill,
} from "react-icons/bs";

const GMale = "male";
const GFemale = "female";
const CreateStaff = () => {
  const [accountStaff, setAccountStaff] = useState({
    username: "",
    password: "",
  });
  const [profileStaff, setProfileStaff] = useState({
    name: "",
    gender: "",
    birthday: "",
    folk: "",
    phone: "",
    email: "",
  });
  const [addressStaff, setAddressStaff] = useState({
    country: "",
    city: "",
    district: "",
    street: "",
  });

  const handleGetUserName = (user) => {
    setAccountStaff({ ...accountStaff, username: user });
  };
  return (
    <div>
      <div className="container-create-staff">
        <div className="main-create-staff">
          <h1>Create Staff</h1>
          <div className="Account">
            <h2>Account</h2>
            <h4>
              <BsFillPersonFill className="icon" />
              Username:{" "}
              <input
                placeholder="enter username"
                value={accountStaff.username}
                onChange={(e) => {
                  setAccountStaff({
                    ...accountStaff,
                    username: e.target.value,
                  });
                }}
              />
            </h4>
            <h4>
              <BsShieldLockFill className="icon" /> Password:{" "}
              <input
                type="password"
                value={accountStaff.password}
                placeholder="enter password"
                onChange={(e) => {
                  setAccountStaff({
                    ...accountStaff,
                    password: e.target.value,
                  });
                }}
              />
            </h4>
          </div>
          <div className="Profile">
            <h2>Profile</h2>
            <div className="flex-container-profile">
              <div className="left-profile flex-profile">
                <h4>
                  <BsFillPersonFill className="icon" />
                  Name:{" "}
                  <input
                    placeholder="enter name"
                    value={profileStaff.name}
                    onChange={(e) => {
                      setProfileStaff({
                        ...profileStaff,
                        name: e.target.value,
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsFillPeopleFill className="input" /> Folk:{" "}
                  <input
                    placeholder="enter folk"
                    value={profileStaff.folk}
                    onChange={(e) => {
                      setProfileStaff({
                        ...profileStaff,
                        folk: e.target.value,
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsGenderAmbiguous className="icon" /> Gender: <br />
                </h4>
                <input
                  type="radio"
                  name="gender"
                  onChange={(e) => {
                    setProfileStaff({ ...profileStaff, gender: GMale });
                  }}
                />{" "}
                MALE
                <input
                  type="radio"
                  name="gender"
                  onChange={(e) => {
                    setProfileStaff({ ...profileStaff, gender: GFemale });
                  }}
                />{" "}
                FEMALE
              </div>
              <div className="right-profile flex-profile">
                <h4>
                  <BsFillCalendarEventFill className="icon" /> Birthday:{" "}
                  <input
                    type="date"
                    value={profileStaff.birthday}
                    onChange={(e) => {
                      setProfileStaff({
                        ...profileStaff,
                        birthday: e.target.value,
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsFillTelephoneFill className="icon" /> Phone:{" "}
                  <input
                    type="number"
                    placeholder="enter phone number"
                    value={profileStaff.phone}
                    onChange={(e) => {
                      setProfileStaff({
                        ...profileStaff,
                        phone: parseInt(e.target.value),
                      });
                    }}
                  />
                </h4>
                <h4>
                  <BsEnvelopeFill className="icon" /> Email:{" "}
                  <input
                    type="email"
                    placeholder="enter email"
                    value={profileStaff.email}
                    onChange={(e) => {
                      setProfileStaff({
                        ...profileStaff,
                        email: e.target.value,
                      });
                    }}
                  />
                </h4>
              </div>
            </div>
          </div>
          <div className="Address">
            <h2>Addresss</h2>
            <h4>
              <BsGeoAltFill className="icon" /> Country:{" "}
              <input
                placeholder="enter country"
                value={addressStaff.country}
                onChange={(e) => {
                  setAddressStaff({ ...addressStaff, country: e.target.value });
                }}
              />
            </h4>
            <h4>
              <BsGeoAltFill className="icon" /> City:{" "}
              <input
                placeholder="enter city"
                value={addressStaff.city}
                onChange={(e) => {
                  setAddressStaff({ ...addressStaff, city: e.target.value });
                }}
              />
            </h4>
            <h4>
              <BsGeoAltFill className="icon" /> District:{" "}
              <input
                placeholder="enter district "
                value={addressStaff.district}
                onChange={(e) => {
                  setAddressStaff({
                    ...addressStaff,
                    district: e.target.value,
                  });
                }}
              />
            </h4>
            <h4>
              <BsGeoAltFill className="icon" /> Street:{" "}
              <input
                placeholder="enter street"
                value={addressStaff.street}
                onChange={(e) => {
                  setAddressStaff({ ...addressStaff, street: e.target.value });
                }}
              />
            </h4>
          </div>
          <div className="btn-create-staff">
            <button>Create</button>
            <button>Cancel</button>
          </div>
        </div>
      </div>
    </div>
  );
};
export default CreateStaff;
