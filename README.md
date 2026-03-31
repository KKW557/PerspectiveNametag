# Perspective Nametag

[![GitHub License](https://img.shields.io/github/license/KKW557/perspectivenametag)](https://github.com/KKW557/perspectivenametag?tab=MIT-1-ov-file#readme)
[![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/KKW557/perspectivenametag/gradle.yml)](https://github.com/KKW557/perspectivenametag/actions/workflows/gradle.yml)
[![GitHub Release](https://img.shields.io/github/v/release/KKW557/perspectivenametag)](https://github.com/KKW557/perspectivenametag/releases/latest)

[![Modrinth Downloads](https://img.shields.io/modrinth/dt/perspectivenametag?logo=modrinth)](https://modrinth.com/mod/perspectivenametag)
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1499392?logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/perspectivenametag)

A mod to show the player's nametag in second/third person perspective.

## FAQ

### Forge/NeoForge？
For the **Forge**/**NeoForge** versions, this mod updates lazily.

### How to toggle nametag (since `1.2.0`)

Some servers may provide their own server-side implementation,
which can cause rendering conflicts with this mod.

To mitigate this,
you can add server addresses to a blacklist by listing them line-by-line in `config/perspectivenametag.server-blacklist.txt`.

```txt
mc.example.com
localhost:12345
127.0.0.1
...
```

For developers, `perspectivenametag-core` exposes an API that allows you to control when nametags are rendered.

See `icu.suc.kkw557.perspectivenametag.PerspectiveNametag` for details.

## License

This project is licensed under the [MIT License](LICENSE) © 2025 557.