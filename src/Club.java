/**
 * @param rank rank of a club
 * @param prevRank previous rank of a club
 * @param name name of a club
 * @param league league of a club
 * @param offensivePoint offensive point of a club
 * @param defensivePoint defensive point of a club
 * @param spiPoint spi of a club
 */
public record Club(String rank,
                   String prevRank,
                   String name,
                   String league,
                   double offensivePoint,
                   double defensivePoint,
                   double spiPoint) {
}
